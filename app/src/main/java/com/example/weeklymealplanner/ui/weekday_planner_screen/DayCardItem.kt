package com.example.weeklymealplanner.ui.weekday_planner_screen

import com.example.weeklymealplanner.R

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DayCardItem(
    day: String,
    recipeName: String,
    modifier: Modifier,
    onClick: () -> Unit,
    onClickRecipe: () -> Unit,
    backgroundColor: Color
) {
    Card(
            onClick = onClick,
            elevation = 10.dp,
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxWidth()
                .wrapContentHeight()

    ) {
        Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .background(backgroundColor)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
        ) {

            Text(
                    text = day,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = modifier
            )

            Spacer(modifier = Modifier.size(16.dp))

            Card(
                    shape = RoundedCornerShape(15),
                    onClick = onClickRecipe,
                    elevation = 10.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 8.dp)
            ) {
                Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()

                ) {

                    Image(painter = painterResource(id = R.drawable.ic_food )  , contentDescription = "Food icon", modifier = Modifier.padding(12.dp))

                    Text(
                            text = recipeName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = modifier
                    )

                }

            }
        }
    }
}