package com.example.weeklymealplanner.data

import androidx.room.Query
import com.example.weeklymealplanner.data.entities.Recipe
import javax.inject.Inject

class RecipeRepository @Inject constructor (

    private val recipeDao: RecipeDao

) {
    suspend fun insertRecipe(recipe: Recipe) {
        recipeDao.insertRecipe(recipe)
    }

    suspend fun getAllRecipes(): List<Recipe> {
        return recipeDao.getAllRecipes()
    }

    suspend fun getRecipeNames(): List<String> {
        return recipeDao.getRecipeNames()
    }

    suspend fun getRecipe(id: Int): Recipe {
        return recipeDao.getRecipe(id)
    }

    suspend fun deleteRecipe(recipe: Recipe) {
        recipeDao.deleteRecipe(recipe)
    }

    suspend fun deleteAll() {
        recipeDao.deleteAll()
    }

    fun updateMondayRecipe(recipeId: Int) {
        recipeDao.updateMondayRecipe(recipeId)
    }


    fun updateTuesdayRecipe(recipeId: Int) {
        recipeDao.updateTuesdayRecipe(recipeId)
    }

    fun updateWednesdayRecipe(recipeId: Int) {
        recipeDao.updateWednesdayRecipe(recipeId)
    }

    fun updateThursdayRecipe(recipeId: Int) {
        recipeDao.updateThursdayRecipe(recipeId)
    }

    fun updateFridayRecipe(recipeId: Int) {
        recipeDao.updateFridayRecipe(recipeId)
    }

    fun updateSaturdayRecipe(recipeId: Int) {
        recipeDao.updateSaturdayRecipe(recipeId)
    }

    fun updateSundayRecipe(recipeId: Int) {
        recipeDao.updateSundayRecipe(recipeId)
    }

    fun resetWeeklyRecipes(recipeId: Int) {
        recipeDao.resetWeeklyRecipes(recipeId)
    }

    fun resetMondayRecipe(recipeId: Int) {
        recipeDao.resetMondayRecipe(recipeId)
    }

    fun resetTuesdayRecipe(recipeId: Int) {
        recipeDao.resetTuesdayRecipe(recipeId)
    }

    fun resetWednesdayRecipe(recipeId: Int) {
        recipeDao.resetWednesdayRecipe(recipeId)
    }

    fun resetThursdayRecipe(recipeId: Int) {
        recipeDao.resetThursdayRecipe(recipeId)
    }

    fun resetFridayRecipe(recipeId: Int) {
        recipeDao.resetFridayRecipe(recipeId)
    }

    fun resetSaturdayRecipe(recipeId: Int) {
        recipeDao.resetSaturdayRecipe(recipeId)
    }

    fun resetSundayRecipe(recipeId: Int) {
        recipeDao.resetSundayRecipe(recipeId)
    }

    fun getMondayRecipe() {
        recipeDao.getMondayRecipe()
    }

    fun getTuesdayRecipe() {
        recipeDao.getTuesdayRecipe()
    }

    fun getWednesdayRecipe() {
        recipeDao.getWednesdayRecipe()
    }

    fun getThursdayRecipe() {
        recipeDao.getThursdayRecipe()
    }

    fun getFridayRecipe() {
        recipeDao.getFridayRecipe()
    }

    fun getSaturdayRecipe() {
        recipeDao.getSaturdayRecipe()
    }

    fun getSundayRecipe() {
        recipeDao.getSundayRecipe()
    }

}