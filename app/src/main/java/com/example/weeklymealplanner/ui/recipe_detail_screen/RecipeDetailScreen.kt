package com.example.weeklymealplanner.ui.recipe_detail_screen

import android.util.Log
import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.weeklymealplanner.R
import com.example.weeklymealplanner.StyleButton
import com.example.weeklymealplanner.data.entities.Recipe
import com.example.weeklymealplanner.ui.destinations.RecipeBookScreenDestination
import com.example.weeklymealplanner.ui.recipe_book_screen.RecipeBookViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch
import java.util.*


@Destination
@Composable
fun RecipeDetailScreen(
    navigator: DestinationsNavigator,
    viewModel: RecipeDetailViewModel = hiltViewModel(),
    id: Int,
    recipeName: String,
    portionSize: Int,
    preparationTime: Int,
    ingredientsAsString: String,
    stepsAsString: String,
) {

    val ingredients = ingredientsAsString.split("^").map { it }
    val steps = stepsAsString.split("^").map { it }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
        .padding(
                vertical = 10.dp, horizontal = 10.dp
        )) {
        Card(
                shape = RoundedCornerShape(5),
                elevation = 10.dp,
                backgroundColor = Color.White,
                modifier = Modifier.fillMaxSize()
//                    .weight(0.9f)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.size(30.dp))
                    Text(
                            text = recipeName, fontWeight = FontWeight.Bold, fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.size(25.dp))
                    Box(
                            modifier = Modifier.fillMaxWidth().height(2.dp)
                                .background(color = Color.DarkGray)
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Spacer(modifier = Modifier.size(25.dp))
                    }

                    item {
                        Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp)
                        ) {
                            Text(
                                    text = "Preparation: $preparationTime min",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                            )

                            Text(
                                    text = "Portions: $portionSize",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                            )
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.size(40.dp))
                    }

                    item {
                        Text(
                                text = "Ingredients",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                    }

                    items(ingredients) { ingredient ->
                        Text(
                                text = ingredient,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(start = 24.dp, bottom = 8.dp)
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.size(60.dp))
                    }

                    item {
                        Text(
                                text = "Steps",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                    }



                    itemsIndexed(steps) { index, step ->
                        Text(
                                text = "${index + 1}. " + step.replaceFirstChar {
                                    if (it.isLowerCase()) it.titlecase(
                                            Locale.getDefault()
                                    ) else it.toString()
                                },
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 24.dp, bottom = 8.dp)
                        )
                    }

                }
            }
            Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {

                IconButton(onClick = {
                    viewModel.viewModelScope.launch {
                        viewModel.deleteRecipe(id)
                        navigator.popBackStack()
                    }
                }) {
                    Icon(
                            painter = painterResource(R.drawable.ic_delete),
                            contentDescription = "Delete recipe",
                            modifier = Modifier.size(64.dp)
                    )

                }
            }
        }
    }}