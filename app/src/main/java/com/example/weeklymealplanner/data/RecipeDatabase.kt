package com.example.weeklymealplanner.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weeklymealplanner.data.entities.Recipe

@Database(
        entities = [Recipe::class], version = 1
)

@TypeConverters(Converters::class)
abstract class RecipeDatabase: RoomDatabase() {

    abstract fun getRecipeDao(): RecipeDao
}