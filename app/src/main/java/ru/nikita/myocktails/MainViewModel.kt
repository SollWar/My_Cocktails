package ru.nikita.myocktails

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
import ru.nikita.myocktails.room.CocktailsRoomDao
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val cocktailsRepository: CocktailsRepository) :
    ViewModel() {

    private val _cocktailsList: MutableStateFlow<List<CocktailEntity>> = MutableStateFlow(listOf())
    val cocktailsList = _cocktailsList.asStateFlow()

    fun getAllCocktail() {
        viewModelScope.launch {
            val cocktailResponse = viewModelScope.async(Dispatchers.IO) {
                return@async cocktailsRepository.getAllCocktails()
            }
            _cocktailsList.value = cocktailResponse.await()
        }
    }

}