package ru.nikita.myocktails.ui.screens.addcocktail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.nikita.myocktails.data.CocktailEntity
import ru.nikita.myocktails.room.CocktailsRepository
import javax.inject.Inject

@HiltViewModel
class AddCocktailViewModel @Inject constructor(private val cocktailsRepository: CocktailsRepository) :
    ViewModel() {

    private val _name = MutableStateFlow("")
    val name = _name.asStateFlow()

    private val _description = MutableStateFlow("")
    val description = _description.asStateFlow()

    private val _recipe = MutableStateFlow("")
    val recipe = _recipe.asStateFlow()

    private val _ingredients = MutableStateFlow<MutableList<String>>(
        mutableListOf()
    )
    var ingredients = _ingredients.asStateFlow()

    fun changeName(name: String) {
        _name.value = name
    }

    fun changeDescription(description: String) {
        _description.value = description
    }

    fun changeRecipe(recipe: String) {
        _recipe.value = recipe
    }

    fun addIngredient(ingredient: String) {
        _ingredients.value.add(ingredient)
    }

    fun removeIngredient(ingredient: String) {
        _ingredients.value.remove(ingredient)
    }

    fun saveCocktail() {
        viewModelScope.launch {
            val cocktailResponse = viewModelScope.async(Dispatchers.IO) {
                return@async cocktailsRepository.insertNewCocktailEntity(
                    CocktailEntity(
                        name = _name.value,
                        description = _description.value,
                        ingredients = _ingredients.value.toList(),
                        recipe = _recipe.value
                    )
                )
            }
        }
    }
}