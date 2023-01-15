package com.example.weeklymealplanner.di

import android.content.Context
import androidx.room.Room
import androidx.room.TypeConverters
import com.example.weeklymealplanner.data.Converters
import com.example.weeklymealplanner.data.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideRecipeDatabase(
        @ApplicationContext app: Context
    ): RecipeDatabase {
        return Room.databaseBuilder(
                app, RecipeDatabase::class.java, "recipe_db"
        )
            .addTypeConverter(Converters())
            .build()
    }


    @Singleton
    @Provides
    fun provideRecipeDao(recipeDatabase: RecipeDatabase) = recipeDatabase.getRecipeDao()
}