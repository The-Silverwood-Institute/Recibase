package se.reciba.api.server

import se.reciba.api.model.MenuEntry
import sttp.model.StatusCode
import sttp.tapir._
import sttp.tapir.generic.auto._
import sttp.tapir.json.circe._

object ApiEndpoints {
  implicit val schemaConfiguration: sttp.tapir.generic.Configuration =
    sttp.tapir.generic.Configuration.default.withSnakeCaseMemberNames
      .withDiscriminator("type")
      .withSnakeCaseDiscriminatorValues

  private val ingredientQuery = query[Option[String]]("hasIngredient")
    .description(
      "Case-insensitive substring of an ingredient name. Prefix with ! to exclude recipes containing that ingredient."
    )

  private val submissionErrors = oneOf[ApiError](
    oneOfVariant(
      StatusCode.BadRequest,
      jsonBody[ApiError].description(
        "The body is not JSON, is larger than 256KiB, or fails validation."
      )
    ),
    oneOfVariant(
      StatusCode.Unauthorized,
      jsonBody[ApiError].description("The bearer passcode is missing or wrong.")
    ),
    oneOfVariant(
      StatusCode.Forbidden,
      jsonBody[ApiError].description("The Turnstile token was rejected.")
    ),
    oneOfVariant(
      StatusCode.Conflict,
      jsonBody[ApiError].description(
        "A recipe with this name already exists, or a submission for it is already open."
      )
    ),
    oneOfVariant(
      StatusCode.BadGateway,
      jsonBody[ApiError].description("GitHub rejected the submission.")
    ),
    oneOfVariant(
      StatusCode.ServiceUnavailable,
      jsonBody[ApiError].description("Recipe submission is not configured.")
    )
  )

  val index: PublicEndpoint[Unit, Unit, Map[String, String], Any] =
    endpoint.get
      .in("")
      .tag("Meta")
      .summary("Route index")
      .description("Names of the public routes and their path templates.")
      .out(jsonBody[Map[String, String]])

  val health: PublicEndpoint[Unit, Unit, String, Any] =
    endpoint.get
      .in("health")
      .tag("Meta")
      .summary("Health check")
      .out(stringBody.example("ok"))

  val manifest: PublicEndpoint[Unit, Unit, ManifestDoc, Any] =
    endpoint.get
      .in("manifest")
      .tag("Meta")
      .summary("Build manifest")
      .out(jsonBody[ManifestDoc])

  val tags: PublicEndpoint[Unit, Unit, TagCatalog, Any] =
    endpoint.get
      .in("tags")
      .tag("Meta")
      .summary("List tags")
      .description(
        "Every tag, with its category, description, and the tags it inherits. Usage tags are calculated by the server and are not written on recipes."
      )
      .out(jsonBody[TagCatalog])

  val recipes: PublicEndpoint[Option[String], Unit, List[MenuEntry], Any] =
    endpoint.get
      .in("recipes")
      .in("")
      .tag("Recipes")
      .summary("List recipes")
      .in(ingredientQuery)
      .out(jsonBody[List[MenuEntry]])

  val recipe: PublicEndpoint[String, String, RecipeDetail, Any] =
    endpoint.get
      .in("recipes" / path[String]("permalink"))
      .tag("Recipes")
      .summary("Fetch a recipe")
      .out(jsonBody[RecipeDetail])
      .errorOut(
        statusCode(StatusCode.NotFound)
          .and(stringBody.description("Recipe not found"))
      )

  val meals: PublicEndpoint[Unit, Unit, List[MealDetail], Any] =
    endpoint.get
      .in("meals")
      .in("")
      .tag("Meals")
      .summary("List meals")
      .description(
        "Every meal, including usage tags, notes, and how often it has been eaten."
      )
      .out(jsonBody[List[MealDetail]])

  val mealNames: PublicEndpoint[Unit, Unit, String, Any] =
    endpoint.get
      .in("meals" / "raw")
      .tag("Meals")
      .summary("List dinner names")
      .description("Dinner names, one per line, sorted.")
      .out(stringBody)

  val submitRecipe: Endpoint[
    String,
    RecipeSubmissionDoc,
    ApiError,
    SubmissionAccepted,
    Any
  ] =
    endpoint.post
      .in("recipe-submissions")
      .tag("Submissions")
      .summary("Submit a recipe")
      .description(
        "Opens a pull request that adds the recipe. Requires a Bearer passcode and a Cloudflare Turnstile token."
      )
      .securityIn(
        auth
          .bearer[String]()
          .description("Contribution passcode.")
      )
      .in(jsonBody[RecipeSubmissionDoc])
      .out(jsonBody[SubmissionAccepted])
      .errorOut(submissionErrors)

  val all: List[AnyEndpoint] = List(
    index,
    health,
    manifest,
    tags,
    recipes,
    recipe,
    meals,
    mealNames,
    submitRecipe
  )
}
