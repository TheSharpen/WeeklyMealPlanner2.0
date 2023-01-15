package com.example.weeklymealplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.weeklymealplanner.data.RecipeDao
import com.example.weeklymealplanner.data.RecipeDatabase
import com.example.weeklymealplanner.ui.NavGraphs
import com.example.weeklymealplanner.ui.add_recipe_screen.AddRecipeViewModel
import com.example.weeklymealplanner.data.entities.Recipe
import com.example.weeklymealplanner.ui.theme.WeeklyMealPlannerTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.spec.NavGraphSpec
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinationsNavHost(navGraph =  NavGraphs.root)
        }
    }
}

@Composable
fun StyleButton(
    text1: String,
    text2: String? = null,
    onClick: () -> Unit,
    buttonWidth: Int = 200,
    buttonHeight: Int = 70,
    buttonTopPadding: Int = 24,
    buttonTextFontSize: Int = 24,
    modifier: Modifier

) {

    Button(
            onClick = onClick,
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .width(buttonWidth.dp)
                .height(buttonHeight.dp)
                .padding(top = buttonTopPadding.dp)
                .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {


            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
                Text(text = text1, fontSize = buttonTextFontSize.sp, fontWeight = FontWeight.Bold)
                text2?.let {
                    Text(
                            text = it,
                            fontSize = buttonTextFontSize.sp,
                            fontWeight = FontWeight.Bold
                    )
                }


            }
        }

    }

}