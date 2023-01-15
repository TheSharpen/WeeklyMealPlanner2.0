package com.example.weeklymealplanner.ui.recipe_book_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weeklymealplanner.data.entities.Recipe
import com.example.weeklymealplanner.ui.destinations.RecipeDetailScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("CoroutineCreationDuringComposition")
@Destination
@Composable
fun RecipeBookScreen(
    navigator: DestinationsNavigator,
    viewModel: RecipeBookViewModel = hiltViewModel()
) {

    val recipeList by remember {viewModel.recipeList}
    val isSearching by remember {viewModel.isSearching}

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(75.dp), ) {
            Text(
                    text = "Recipe Book",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center)
            )
        }
        Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .border(width = 3.dp, color = Color.DarkGray)
        )

        SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
        ) {
            viewModel.searchRecipeList(it)
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(recipeList) { recipe ->
                RecipeCard(
                        recipeName = recipe.recipeName,
                        modifier = Modifier,
                        onClick = {
                            navigator.navigate(RecipeDetailScreenDestination(
                                    id = recipe.id!!,
                                    recipeName = recipe.recipeName,
                                    portionSize = recipe.portionForPersonsNumber,
                                    preparationTime = recipe.preparationDurationInMinutes,
                                    ingredientsAsString = recipe.ingredients.joinToString("^"),
                                    stepsAsString = recipe.steps.joinToString("^")
                            ))
                        }
                )
            }
        }
    }
}