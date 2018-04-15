# Recibase

[![Build Status](https://travis-ci.org/The-Silverwood-Institute/Recibase.svg?branch=master)](https://travis-ci.org/The-Silverwood-Institute/Recibase)

Recibase is a recipe ingestion and navigation service, designed to ease the choosing of what to cook.

Recibase works like so:

1. Write [CSON files][recipes] containing your recipes
2. Recibase reads in the recipes and adds them to a local database
3. [The frontend][frontend] lets you browse recipes by name, ingredient and more

## Roadmap

Recibase is a long term project which will grow depending on what features are useful or interesting to develop. The current plan is:

1. Standardise ingredients schema
2. Add a bunch of recipes
3. Add any small but useful features to improve frontend
4. Improve ingestion debugging capabilities (churn/reporting/etc.)
5. Continue to develop schema
6. Migrate frontend to separate React client and REST API
7. Add microservices for useful client-side functionality (favouriting, etc.)
8. ???
9. Profit

## Requirements

- SBT
- Python 2.7
- Java 8

## Installation

*Note: Recibase uses [git submodules][git-submodules] (yes, I know)*

1. Clone Recibase
2. Open a command prompt inside the cloned repo
3. Run `git submodule update --init --recursive` to download Recibase's dependent GitHub projects
4. Navigate to the `/estherj`
5. Run `pip install -r requirements.txt`

## Contributing/Questions

If you have any questions or want to help out feel free to [open an issue][new-issue].

[recipes]: https://github.com/The-Silverwood-Institute/Recipes
[frontend]: https://github.com/The-Silverwood-Institute/Frontend
[git-submodules]: https://git-scm.com/book/en/v2/Git-Tools-Submodules
[new-issue]: https://github.com/The-Silverwood-Institute/Recibase/issues/new
