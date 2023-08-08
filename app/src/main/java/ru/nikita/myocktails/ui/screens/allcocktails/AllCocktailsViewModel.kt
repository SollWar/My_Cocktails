package ru.nikita.myocktails.ui.screens.allcocktails

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
class AllCocktailsViewModel @Inject constructor(private val cocktailsRepository: CocktailsRepository) :
    ViewModel() {

    private val _cocktails = MutableStateFlow<List<CocktailEntity>>(
        listOf()
    )
    var cocktails = _cocktails.asStateFlow()


    fun loadingCocktails() {
        viewModelScope.launch {
            val cocktailResponse = viewModelScope.async(Dispatchers.IO) {
                return@async cocktailsRepository.getAllCocktails()
            }
            _cocktails.value = cocktailResponse.await()
        }
    }
}