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

[recipes]: https://github.com/The-Silverwood-Institute/Recipes
[frontend]: https://github.com/The-Silverwood-Institute/Frontend
