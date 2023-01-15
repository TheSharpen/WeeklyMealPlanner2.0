package com.example.weeklymealplanner.data

import androidx.room.*
import com.example.weeklymealplanner.data.entities.Recipe

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: Recipe)

    @Query("SELECT * FROM Recipe")
    suspend fun getAllRecipes(): List<Recipe>

    @Query("SELECT * FROM Recipe WHERE id = :id ")
    suspend fun getRecipe(id: Int): Recipe

    @Query("SELECT recipeName FROM Recipe")
    suspend fun getRecipeNames(): List<String>

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    @Query("DELETE FROM Recipe")
    suspend fun deleteAll()

    @Query("UPDATE Recipe SET mondayRecipe = 1 WHERE id = :recipeId")
    fun updateMondayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET tuesdayRecipe = 1 WHERE id = :recipeId")
    fun updateTuesdayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET wednesdayRecipe = 1 WHERE id = :recipeId")
    fun updateWednesdayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET thursdayRecipe = 1 WHERE id = :recipeId")
    fun updateThursdayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET fridayRecipe = 1 WHERE id = :recipeId")
    fun updateFridayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET saturdayRecipe = 1 WHERE id = :recipeId")
    fun updateSaturdayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET sundayRecipe = 1 WHERE id = :recipeId")
    fun updateSundayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET mondayRecipe = NULL , tuesdayRecipe = NULL , wednesdayRecipe = NULL, thursdayRecipe = NULL, fridayRecipe = NULL, saturdayRecipe = NULL, sundayRecipe = NULL WHERE id = :recipeId")
    fun resetWeeklyRecipes(recipeId: Int)

    @Query("UPDATE Recipe SET mondayRecipe = NULL WHERE id = :recipeId")
    fun resetMondayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET tuesdayRecipe = NULL WHERE id = :recipeId")
    fun resetTuesdayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET wednesdayRecipe = NULL WHERE id = :recipeId")
    fun resetWednesdayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET thursdayRecipe = NULL WHERE id = :recipeId")
    fun resetThursdayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET fridayRecipe = NULL WHERE id = :recipeId")
    fun resetFridayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET saturdayRecipe = NULL WHERE id = :recipeId")
    fun resetSaturdayRecipe(recipeId: Int)

    @Query("UPDATE Recipe SET sundayRecipe = NULL WHERE id = :recipeId")
    fun resetSundayRecipe(recipeId: Int)

    @Query("SELECT * FROM Recipe WHERE mondayRecipe = 1")
    fun getMondayRecipe(): Recipe?

    @Query("SELECT * FROM Recipe WHERE tuesdayRecipe = 1")
    fun getTuesdayRecipe(): Recipe?

    @Query("SELECT * FROM Recipe WHERE wednesdayRecipe = 1")
    fun getWednesdayRecipe(): Recipe?

    @Query("SELECT * FROM Recipe WHERE thursdayRecipe = 1")
    fun getThursdayRecipe(): Recipe?

    @Query("SELECT * FROM Recipe WHERE fridayRecipe = 1")
    fun getFridayRecipe(): Recipe?

    @Query("SELECT * FROM Recipe WHERE saturdayRecipe = 1")
    fun getSaturdayRecipe(): Recipe?

    @Query("SELECT * FROM Recipe WHERE sundayRecipe = 1")
    fun getSundayRecipe(): Recipe?


}