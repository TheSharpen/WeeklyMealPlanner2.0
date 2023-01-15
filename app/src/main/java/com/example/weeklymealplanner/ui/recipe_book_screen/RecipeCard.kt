package com.example.weeklymealplanner.ui.recipe_book_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecipeCard(
    recipeName: String,
    modifier: Modifier,
    onClick: () -> Unit, //this means LAMBDA fun is passed instead of regular fun
) {
    Card(shape = RoundedCornerShape(15),
            onClick = onClick,
            elevation = 10.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(16.dp))
    {
        Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                //.height(140.dp)
                .background(Color.Gray)
                .weight(0.7f)) {
            }
            Text(
                    text = recipeName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .weight(0.3f)
                        .align(Alignment.CenterHorizontally)
                        .padding(12.dp)
            )
        }
    }

}