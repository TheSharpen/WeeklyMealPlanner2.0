package com.example.weeklymealplanner.ui.recipe_book_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import com.example.weeklymealplanner.R
import com.example.weeklymealplanner.data.entities.Recipe
import com.example.weeklymealplanner.data.RecipeDao
import com.example.weeklymealplanner.data.RecipeDatabase
import com.example.weeklymealplanner.data.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeBookViewModel @Inject constructor(
    private val recipeDatabase: RecipeDatabase,
    private val recipeRepository: RecipeRepository
): ViewModel()  {

    //search function variables
    // var recipeList = mutableStateOf<List<Recipe>>(listOf())
    var recipeList: MutableState<List<Recipe>> = mutableStateOf(listOf())
    private var cachedRecipeList = listOf<Recipe>()
    private var isSearchStarting = true //true if search field is empty
    var isSearching = mutableStateOf(false) //true as long as s earch results are shown

    fun searchRecipeList(query: String) {
        val listToSearch = if (isSearchStarting) {
            recipeList.value
        } else {
            // if at least one character is typed, list is backed up to cached list and list
            // will contain only the search results
            cachedRecipeList
        }
        viewModelScope.launch(Dispatchers.Default){
            if (query.isEmpty()) {
                recipeList.value = cachedRecipeList // in case the search bar is erased and is empty again
                isSearching.value = false // reset value to false because we don't want the serach results
                isSearchStarting = true // true because serach is ready to start again
                return@launch
            }

            val results = listToSearch.filter {
                it.recipeName.contains(query.trim(), ignoreCase = true)
            }

            if (isSearchStarting) {
                cachedRecipeList = recipeList.value
                isSearchStarting = false
            }
            recipeList.value = results
            isSearching.value = true

        }
    }

    //val allRecipes = recipeRepository.getAllRecipes()

    var allRecipesAsMutableState: MutableState<List<Recipe>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            val result = recipeRepository.getAllRecipes()
            allRecipesAsMutableState.value = result
        }
        viewModelScope.launch {
            val result = recipeRepository.getAllRecipes()
            recipeList.value = result
        }
    }
}