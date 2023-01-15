package com.example.weeklymealplanner.ui.recipe_detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weeklymealplanner.data.entities.Recipe
import com.example.weeklymealplanner.data.RecipeDatabase
import com.example.weeklymealplanner.data.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val recipeDatabase: RecipeDatabase,
    private val recipeRepository: RecipeRepository
): ViewModel()  {

    suspend fun getRecipe(id: Int): Recipe {
        return recipeRepository.getRecipe(id)
    }

    suspend fun deleteRecipe(id: Int) {
        recipeRepository.deleteRecipe(getRecipe(id))
    }



}