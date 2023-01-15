package com.example.weeklymealplanner.ui.add_recipe_screen

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.weeklymealplanner.R
import com.example.weeklymealplanner.StyleButton
import com.example.weeklymealplanner.data.entities.Recipe
import com.example.weeklymealplanner.data.RecipeDatabase
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*



@SuppressLint("CoroutineCreationDuringComposition")
@Destination
@Composable
fun AddRecipeScreen(
    navigator: DestinationsNavigator,
    viewModel: AddRecipeViewModel = hiltViewModel()

) {




    var recipeNameString by remember { mutableStateOf(TextFieldValue()) }
    var portionSizeString by remember { mutableStateOf(TextFieldValue()) }
    var preparationDurationString by remember { mutableStateOf(TextFieldValue()) }
    var ingredientsList by remember { mutableStateOf(listOf<String>()) }
    var ingredient by remember { mutableStateOf(TextFieldValue()) }
    var stepsList by remember { mutableStateOf(listOf<String>()) }
    var step by remember { mutableStateOf(TextFieldValue()) }




//    val sampleRecipes = listOf(
//            Recipe(
//                    "October recipe",
//                    4,
//                    60,
//                    listOf("ing1", "ing2", "ing3"),
//                    listOf("action1","action20","action30")
//            ),
//            Recipe(
//                    "December recipe",
//                    10,
//                    200,
//                    listOf("ingX", "ingY", "ingZ"),
//                    listOf("actionUno","actionDuos","actionTres")
//            )
//
//    )


    //Deletion of current database
//    viewModel.viewModelScope.launch {
//
//        viewModel.deleteAll()
//
//    }


//    viewModel.checkForDuplicates("Nothing")




    Column(
            horizontalAlignment = Alignment.Start, modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)

    ) {
        //Below test works = called only once
        //StyleButton(text1 = "test", onClick = { viewModel.checkForDuplicates("Quick Morning Oats") }, modifier = Modifier )

        LazyColumn {

            item {
                OutlinedTextField(value = recipeNameString, onValueChange = {
                    recipeNameString = it
                }, maxLines = 1, label = {
                    Text(text = "Recipe Name")
                })
            }

            item { Spacer(modifier = Modifier.height(30.dp)) }

            item {
                OutlinedTextField(value = portionSizeString, onValueChange = {
                    portionSizeString = it
                }, maxLines = 1, label = {
                    Text(text = "Number of portions")
                })
            }

            item {
                OutlinedTextField(value = preparationDurationString, onValueChange = {
                    preparationDurationString = it
                }, maxLines = 1, label = {
                    Text(text = "Preparation in minutes")
                })
            }

            item { Spacer(modifier = Modifier.height(30.dp)) }

            item {


                Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    OutlinedTextField(value = ingredient, onValueChange = {
                        ingredient = it
                    }, label = {
                        Text(text = "Ingredients")
                    })

                    Button(modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, top = 8.dp),
                            onClick = {
                                if (ingredient != TextFieldValue("")) {
                                    ingredientsList = ingredientsList.plus(ingredient.text)
                                    ingredient = TextFieldValue("")
                                    println(ingredientsList)
                                }
                                println("Nothing has been entered to STEPS field ")

                            }) {
                        Text(text = "ADD", fontSize = 18.sp)
                    }
                }
            }

            item {
                Column {

                    for ((index, eachIngredient) in ingredientsList.withIndex()) {

                        Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                        ) {


                            Text(
                                    text = eachIngredient,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp)
                            )

                            Button(onClick = {
                                ingredientsList = ingredientsList.minusElement(eachIngredient)

                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Icon Delete")

                            }
                        }



                    }

                }
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
            item {
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    OutlinedTextField(value = step, onValueChange = {
                        step = it
                    }, label = {
                        Text(text = "Steps")
                        //TODO: add exclamation mark icon explaining to add 1 ing per 1 row then enter and remove description from label, leave just ingredients
                    })

                    Button(modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, top = 8.dp),
                            onClick = {

                                if (step != TextFieldValue("")) {

                                    stepsList = stepsList.plusElement(step.text.toString())

                                    step = TextFieldValue("")

                                }
                                println("Nothing has been entered to STEPS field ")

                            }) {
                        Text(text = "ADD", fontSize = 18.sp)
                    }
                }
            }

            item {
                Column {

                    Log.d("TAG", "stepsList value FOR : $stepsList")
                    for ((index, eachStep) in stepsList.withIndex()) {

                        Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                        ) {


                            Text(
                                    text = "${index+1}. " + eachStep.replaceFirstChar {
                                        if (it.isLowerCase()) it.titlecase(
                                                Locale.getDefault()
                                        ) else it.toString()
                                    },
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp)
                            )

                            Button(onClick = {
                                stepsList = stepsList.minusElement(eachStep)

                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Icon Delete")

                            }

                        }
                    }

                }
            }


            item {
                Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                ) {
                    val mContext = LocalContext.current

                    StyleButton(text1 = "Save Recipe", onClick = {
                        //viewModel.testHello()
                        //viewModel.checkForDuplicates("Quick Morning Oats")
                        //viewModel.checkForDuplicates("XYOR")
                        if (recipeNameString.text == "")  {
                            Toast.makeText(mContext, "Must enter Recipe Name",Toast.LENGTH_SHORT).show()
                        } else if (portionSizeString.text == "") {
                            Toast.makeText(mContext, "Must enter Portion Size",Toast.LENGTH_SHORT).show()
                        } else if (preparationDurationString.text == "") {
                            Toast.makeText(mContext, "Must enter Preparation Time",Toast.LENGTH_SHORT).show()
                        } else if (ingredientsList.isEmpty()) {
                            Toast.makeText(mContext, "Must add Ingredients",Toast.LENGTH_SHORT).show()
                        } else if (stepsList.isEmpty()) {
                            Toast.makeText(mContext, "Must add Steps",Toast.LENGTH_SHORT).show()
                        }
                        else if (viewModel.checkForDuplicates(recipeNameString.text)) {
                            Toast.makeText(mContext, "Recipe with this name has already been added",Toast.LENGTH_SHORT).show()
                        }
                        else viewModel.viewModelScope.launch {
                            viewModel.insertRecipe(
                                    Recipe(
                                            recipeName = recipeNameString.text,
                                            portionForPersonsNumber = portionSizeString.text.toInt(),
                                            preparationDurationInMinutes = preparationDurationString.text.toInt(),
                                            ingredients = ingredientsList,
                                            steps = stepsList
                                    )
                            ).also {
                                navigator.popBackStack()
                            }
                        }
                    }, modifier = Modifier)
                } }
        }
    }
}