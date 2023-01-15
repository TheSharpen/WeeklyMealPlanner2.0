package com.example.weeklymealplanner.data.entities

import androidx.room.*
import com.example.weeklymealplanner.data.Converters


@Entity(tableName = "Recipe")

class Recipe (

    @ColumnInfo(name = "recipeName")
    val recipeName: String,

    @ColumnInfo(name = "portionSize")
    val portionForPersonsNumber: Int,

    @ColumnInfo(name = "preparationTime")
    val preparationDurationInMinutes: Int,

    @TypeConverters(Converters::class)
    @ColumnInfo(name = "Ingredients")
    val ingredients: List<String>,

    @TypeConverters(Converters::class)
    @ColumnInfo(name = "preparationGuide")
    val steps: List<String>,

    @ColumnInfo(name = "mondayRecipe")
    val mondayRecipe: Boolean? = null,

    @ColumnInfo(name = "tuesdayRecipe")
    val tuesdayRecipe: Boolean? = null,

    @ColumnInfo(name = "wednesdayRecipe")
    val wednesdayRecipe: Boolean? = null,

    @ColumnInfo(name = "thursdayRecipe")
    val thursdayRecipe: Boolean? = null,

    @ColumnInfo(name = "fridayRecipe")
    val fridayRecipe: Boolean? = null,

    @ColumnInfo(name = "saturdayRecipe")
    val saturdayRecipe: Boolean? = null,

    @ColumnInfo(name = "sundayRecipe")
    val sundayRecipe: Boolean? = null,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    )
