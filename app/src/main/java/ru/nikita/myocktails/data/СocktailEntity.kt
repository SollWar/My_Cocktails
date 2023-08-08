package ru.nikita.myocktails.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.nikita.myocktails.R

@Entity(tableName = "cocktails")
data class CocktailEntity(
    @PrimaryKey var name: String = "name",
    var image: Int = R.drawable.cocktail_demo,
    var description: String = "description",
    var ingredients: List<String> = listOf("ingredients 1", "ingredients 2", "ingredients3"),
    var recipe: String = "recipe"
)