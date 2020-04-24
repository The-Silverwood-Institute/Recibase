package com.herokuapp.recibase

case class Ingredient(
                       name: String,
                       quantity: Option[String] = None,
                       prep: Option[String] = None,
                       notes: Option[String] = None
                     )

case class Recipe(
                   name: String,
                   url: String,
                   description: Option[String],
                   tagline: Option[String],
                   notes: Option[String],
                   ingredients: List[Ingredient],
                   method: List[String]
                 )
