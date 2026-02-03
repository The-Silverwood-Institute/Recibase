# Recibase

![Docker image build status](https://github.com/The-Silverwood-Institute/Recibase/actions/workflows/build.yml/badge.svg)

Recibase is a recipe ingestion and navigation service, designed to ease the choosing of what to cook.

Recibase works like so:

1. Write [Scala files][recipes] containing or linking to your recipes
2. Recibase spins up [a recipe API][recipe-api]
3. [The frontend][frontend] lets you browse recipes by name, ingredient and more

There is also a separate [CDN][recipe-images] to host images of the cooked recipes and a [Meal Chooser][meal-chooser] for filtering a complete list of everything we cook.

## Platform Architecture

![architecture-diagram](architecture.svg)

## Roadmap

Recibase is a long term project which will grow depending on what features are useful or interesting to develop. The current plan is:

1. ~~Standardise ingredients schema~~
2. ~~Add a bunch of recipes~~
3. ~~Add any small but useful features to improve frontend~~
4. Improve ingestion debugging capabilities (churn/reporting/etc.)
5. Continue to develop schema
6. Migrate frontend to separate React client and REST API
7. Add microservices for useful client-side functionality (favouriting, etc.)
8. ???
9. Profit

## Requirements

- SBT
- Java 17

## Usage

1. Clone Recibase
2. Open a command prompt inside the cloned repo
3. `sbt run`
4. Wait until the program says `started at http://[::]:8081/`
5. Visit `localhost:8081/recipes/`

If you want to use the web interface you'll need to set up the [frontend][frontend] too

## Parsing recipes

I've been using AI (yes, I know) to fix the disparity of our meal collection mostly existing outside Recibase, by scanning the various photos we have of recipe cards and book pages. Here's prompts used to get recipe parts from photos:

> This photo contains the steps to cook a recipe, split into two columns. Please OCR the recipe's method, ignoring any red text. The output should be a JSON array of strings. Ask for any clarification if needed. Replace any dashes "–" with "-" and any apostraphes "’" with "'". Newlines indicate new array elements. Array elements should always end with a full stop.

> Please OCR the recipes in the `photographs` directory and write a Scala recipe for each recipe. Create the new Scala files in the `src/main/scala/se/reciba/api/recibase/recipes` directory. Each subfolder in the `photographs` is a recipe. Use the name of each subfolder as the name of the recipe. Structure the new recipe Scala files similarly to the existing recipe Scala files. Ignore fields you do not have data for like `image`, `notes` or `tags`. The `permalink` of the recipe should be the name of the recipe lowercase then  kebab-case formatted. The name of each recipe Scala file should be the recipe name with no spaces and Studly Case formatted. If a step in the recipe's method is too long split it into two steps.

## Contributing/Questions

If you have any questions or want to help out feel free to [open an issue][new-issue]

### How to tag meals

Meals that we cook are defined in two places:
- [Entire recipes](https://github.com/The-Silverwood-Institute/Recibase/tree/master/src/main/scala/se/reciba/api/recibase/recipes): Ingredients, preparation steps and more
- [Meal Stubs](https://github.com/The-Silverwood-Institute/Recibase/blob/master/src/main/scala/se/reciba/api/recibase/MealDefinitions.scala): References to full recipes stored elsewhere or from memory. They're like library reference cards

Both have tags, to help with filtering our list of meals in order to choose what to cook. Tags are defined [here](https://github.com/The-Silverwood-Institute/Recibase/blob/master/src/main/scala/se/reciba/api/recibase/model/Tag.scala). Every recipe has tags defined as a comma separated list inside the recipe's file, like so:
```scala
val tags = Set(Tag.Vegetarian, Tag.Slow, Tag.Scales)
```
Every Meal Stub has its tags defined as the 2nd parameter:
```scala
MealStub("Aubergine curry", Set(Tag.Vegan, Tag.Scales, Tag.Slow))
```
The 3rd parameter is an optional link to the full recipe, which is only defined if that recipe exists on the internet.

[recipes]: https://github.com/The-Silverwood-Institute/Recibase/tree/master/src/main/scala/se/reciba/api/recibase/recipes
[recipe-api]: https://api.reciba.se/
[frontend]: https://github.com/The-Silverwood-Institute/Frontend
[new-issue]: https://github.com/The-Silverwood-Institute/Recibase/issues/new
[recipe-images]: https://github.com/The-Silverwood-Institute/Recipe-Images/
[meal-chooser]: https://c.reciba.se/
