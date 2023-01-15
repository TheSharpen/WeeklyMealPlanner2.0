package com.example.weeklymealplanner.ui

import com.example.weeklymealplanner.R
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.weeklymealplanner.StyleButton
import com.example.weeklymealplanner.data.entities.Recipe
import com.example.weeklymealplanner.data.RecipeDatabase
import com.example.weeklymealplanner.ui.destinations.AddRecipeScreenDestination
import com.example.weeklymealplanner.ui.destinations.RecipeBookScreenDestination
import com.example.weeklymealplanner.ui.recipe_book_screen.RecipeBookScreen
import com.example.weeklymealplanner.ui.weekday_planner_screen.DayCardItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch


@Destination(start = true)
@Composable
fun WeekdayPlannerScreen(
    navigator: DestinationsNavigator
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
                text = "Weekly Meal Planner",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(32.dp) //.weight(0.15f)
        )

        LazyColumn(
                // modifier = Modifier.weight(0.7f)
        ) {
            item {
                DayCardItem(
                        day = "Monday",
                        recipeName = "Quick Morning Hardcode",
                        modifier = Modifier,
                        onClick = { /*TODO*/ },
                        onClickRecipe = { /*TODO*/ },
                        backgroundColor = Color.LightGray
                )
            }

            item {
                DayCardItem(
                        day = "Tuesday",
                        recipeName = "You will be hungry =D",
                        modifier = Modifier,
                        onClick = { /*TODO*/ },
                        onClickRecipe = { /*TODO*/ },
                        backgroundColor = Color.DarkGray
                )
            }

            item {
                DayCardItem(
                        day = "Wednesday",
                        recipeName = "You will be hungry =D",
                        modifier = Modifier,
                        onClick = { /*TODO*/ },
                        onClickRecipe = { /*TODO*/ },
                        backgroundColor = Color.LightGray
                )
            }

            item {
                DayCardItem(
                        day = "Thursday",
                        recipeName = "You will be hungry =D",
                        modifier = Modifier,
                        onClick = { /*TODO*/ },
                        onClickRecipe = { /*TODO*/ },
                        backgroundColor = Color.DarkGray
                )
            }

            item {
                DayCardItem(
                        day = "Friday",
                        recipeName = "You will be hungry =D",
                        modifier = Modifier,
                        onClick = { /*TODO*/ },
                        onClickRecipe = { /*TODO*/ },
                        backgroundColor = Color.LightGray
                )
            }

            item {
                Spacer(modifier = Modifier.size(150.dp))
            }

        }


    }
    Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
            //.weight(0.15f)
    ) {

        IconButton(onClick = { navigator.navigate(AddRecipeScreenDestination()) }) {
            Icon(
                    painter = painterResource(R.drawable.ic_add_circle),
                    contentDescription = "Add recipe",
                    modifier = Modifier.size(64.dp)
            )
        }
    }

    Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
            //.weight(0.15f)
    ) {

        IconButton(onClick = { navigator.navigate(RecipeBookScreenDestination) }) {
            Icon(
                    painter = painterResource(R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Recipe Book",
                    modifier = Modifier.size(64.dp)
            )
        }


    }
}


