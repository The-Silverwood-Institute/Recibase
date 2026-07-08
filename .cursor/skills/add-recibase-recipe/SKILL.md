---
name: add-recibase-recipe
description: Add or edit Recibase recipes in Scala. Use when the user asks to add a recipe, convert recipe text into code, or work in src/main/scala/se/reciba/api/recibase/recipes/.
---

# Add a Recibase Recipe

## Overview

Recipes are Scala `case object`s in `src/main/scala/se/reciba/api/recibase/recipes/`. They are auto-discovered via reflection — **no registry or route changes needed**.

## Workflow

1. Read 1–2 nearby recipes for style (e.g. `ChilliConCarne.scala`, `BirthdayCake2.scala`).
2. Create `PascalCase.scala` matching the `case object` name (e.g. `BeefStroganoff.scala`).
3. Use package `se.reciba.api.recipes` (not `recibase.recipes`).
4. Set `createdAt` to today's date.
5. Pick tags from `Tag` in `src/main/scala/se/reciba/api/recibase/model/Tag.scala`.
6. Verify the file compiles / has no linter errors.

## Template

```scala
package se.reciba.api.recipes

import cats.syntax.option._
import se.reciba.api.model.{Ingredient, Recipe, Tag, IngredientsBlock}
import se.reciba.api.utils.IntUtils.TemperatureUtils
import java.time.LocalDate

case object ExampleRecipe extends Recipe {
  val name = "Example Recipe"
  val createdAt = LocalDate.of(2026, 7, 8)

  val tags = Set(Tag.Scales, Tag.LowEffort)

  val ingredientsBlocks = IngredientsBlock.simple(
    Ingredient("Onion", "1"),
    Ingredient("Salt", "Pinch")
  )

  val method = List(
    s"Preheat the oven to ${180.celsius}.",
    "Serve immediately."
  )
}
```

## Required fields

| Field | Notes |
|-------|-------|
| `name` | Display name; permalink is derived automatically (`beef-stroganoff`) |
| `createdAt` | `LocalDate.of(year, month, day)` |
| `tags` | `Set(Tag.…)` — see tag list below |
| `ingredientsBlocks` | `List[IngredientsBlock]` |
| `method` | `List[String]`, one step per string |

## Optional fields

- `source` — URL or attribution string
- `description` — short summary
- `tagline` — one-liner
- `notes` — `List[String]` of extra tips (HTML links allowed)
- `image` — `Image("https://i.reciba.se/…").some`
- `permalink` — override only when the auto slug is wrong (`Permalink("custom-slug")`)

Ice cream recipes extend `Recipe with IceCream` and reuse shared ingredients/method from `IceCream.scala`.

## Ingredients

### Single section

```scala
val ingredientsBlocks = IngredientsBlock.simple(
  Ingredient("Onion", "1"),
  Ingredient("Plain Flour", "200g")
)
```

### Multiple sections

Use named blocks. Order sections as the user requests (e.g. cake before topping):

```scala
val ingredientsBlocks: List[IngredientsBlock] = List(
  IngredientsBlock("Cake", List(
    Ingredient("Plain Flour", "375g")
  )),
  IngredientsBlock("Topping", List(
    Ingredient("Walnuts", "60g")
  ))
)
```

### Ingredient constructors

Use the companion `apply` helpers when possible:

```scala
Ingredient("Onion", "1")                          // name + quantity
Ingredient("Cream Cheese", "250g", "soft")        // + prep
Ingredient("Honey", "1 tbsp".some, None, "Optional".some)  // + notes
```

When passing `Option` fields directly to the case class, use `.some` for quantity/notes:

```scala
Ingredient("Beef", "500g".some, None, "Not fillet".some)
Ingredient("Stock Cube", None, None, "Or 1 tbsp Bovril".some)
```

**Common mistake:** `Ingredient("Beef", "500g", notes = …)` fails — `"500g"` is not `Option[String]`.

## Method steps

- One step per `List` element.
- Use British spelling (`centre`, `flavour`) to match existing recipes.
- Write fractions as `1/2`, `1/4` not `½`.
- Prefix steps by section when helpful: `"Topping: …"`, `"Cake: …"`.
- For oven temperatures, use `TemperatureUtils`:

```scala
import se.reciba.api.utils.IntUtils.TemperatureUtils
s"Preheat the oven to ${180.celsius}."  // → "180°C (355°F, gas mark 4)"
```

## Tags

Pick from existing tags only (`Tag.scala`). Common choices:

| Category | Tags |
|----------|------|
| Meal type | `Pudding`, `Lunch`, `Baking`, `Soup`, `Christmas` |
| Dietary | `Vegan`, `VeganIsh`, `Vegetarian`, `VegetarianIsh`, `Pescatarian` |
| Vibe | `Stodge`, `Spicy`, `ColdWeather`, `HotWeather` |
| Effort | `Slow`, `Quick`, `Scales`, `HighEffort`, `LowEffort` |
| Storage | `Freezes`, `BetterNextDay` |

Do **not** add `NeverEaten`, `Popular`, `Infrequent`, or `New` — those are applied automatically.

Meat dishes often use `VegetarianIsh` (not `Vegetarian`). Baking/puddings use `Pudding` + `Baking` + `Vegetarian` when egg/dairy only.

## Conventions

- Match naming and tone of neighbouring recipes; don't over-comment.
- Put ingredient alternatives or cut guidance in `notes` on the ingredient, not in `method`.
- Keep the diff to one new file unless editing an existing recipe.
- Filename = `case object` name = `productPrefix` used in the GitHub edit link.

## Examples in this repo

- Simple savoury: `BeefStroganoff.scala`, `ChilliConCarne.scala`
- Multi-section baking: `CrunchChocolateChipCoffeeCake.scala`, `BirthdayCake2.scala`
- With source/notes/image: `Brownies.scala`
- Ice cream: `PistachioIceCream.scala`
