package com.example.weeklymealplanner.ui.add_recipe_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weeklymealplanner.data.entities.Recipe
import com.example.weeklymealplanner.data.RecipeDao
import com.example.weeklymealplanner.data.RecipeDatabase
import com.example.weeklymealplanner.data.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class AddRecipeViewModel  @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val recipeDatabase: RecipeDatabase
): ViewModel()  {

    var recipeList: MutableState<List<Recipe>> = mutableStateOf(listOf())
    var duplicateBoolean: Boolean = false
    var recipeListNames: MutableState<List<String>> = mutableStateOf(listOf())
    var ifDuplicate: Boolean = false

    init {
        viewModelScope.launch {
            val results = recipeRepository.getAllRecipes()
            recipeList.value = results
            // list is updated with values from db
        }
        viewModelScope.launch {
            val results = recipeRepository.getRecipeNames()
            recipeListNames.value = results
            Log.d("RecipeListNames","${recipeListNames.value}")
        }
    }

    // WORKING! <3 :D
    fun checkForDuplicates(query: String): Boolean = runBlocking {
        var listToCompare1 = recipeListNames.value.toMutableList()
        var listToCompare2 = recipeListNames.value.toMutableList()
        coroutineScope {
            listToCompare2.add(query)
            val result = listToCompare1.containsAll(listToCompare2)
            Log.d("ListToCompare","list1 contains all of list 2 = $result")
            Log.d("ListToCompare1",listToCompare1.toString())
            Log.d("ListToCompare2",listToCompare2.toString())
            ifDuplicate = result
        }
        Log.d("ListToCompare2", "Returning boolean: $ifDuplicate ")
        ifDuplicate
    }

    suspend fun getRecipe(id: Int): Recipe {
        return recipeRepository.getRecipe(id)
    }

    suspend fun deleteAll() {
        recipeRepository.deleteAll()
    }

    fun coroutineDeleteAll() {
        viewModelScope.launch {

        }
    }

    suspend fun insertRecipe(recipe: Recipe) {
        recipeRepository.insertRecipe(recipe)
    }
}