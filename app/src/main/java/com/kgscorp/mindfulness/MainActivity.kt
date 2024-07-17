package com.kgscorp.mindfulness

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kgscorp.mindfulness.ui.theme.MindfulnessTheme
import com.kgscorp.mindfulness.ui.theme.interFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindfulnessTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavHost(navController = navController, startDestination = "mainScreen") {
                        composable("mainScreen") { mainScreen(navController) }
                        composable("Recommendations") {
                            Recommendations(navController = navController) {
                                navController.popBackStack()
                            }
                        }
                        composable(route = "settings") {
                            settings(navController = navController) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Button to navigate to Recommendations
                    Button(
                        onClick = { navController.navigate("Recommendations") },
                        modifier = Modifier.size(150.dp, 50.dp)
                    ) {
                        Text("Recommendations")
                    }

                    // Spacer for layout
                    Spacer(modifier = Modifier.width(16.dp))

                    IconButton(
                        onClick = { navController.navigate("settings") },
                        modifier = Modifier.size(50.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings",
                            modifier = Modifier.size(45.dp)
                        )
                    }
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            val backgroundColor = MaterialTheme.colorScheme.background
            DynamicText(
                text = "Dynamic color test",
                backgroundColor = backgroundColor,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

fun getContrastingColor(backgroundColor: Color): Color {
    val luminance = backgroundColor.luminance()
    return if (luminance > 0.5) Color.Black else Color.White
}

@Composable
fun DynamicText(
    text: String,
    backgroundColor: Color,
    fontFamily: FontFamily? = interFontFamily,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: androidx.compose.ui.unit.TextUnit = 16.sp,
    color: Color = Color.Black,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val textColor = getContrastingColor(backgroundColor)
    Text(
        text = text,
        color = textColor,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        modifier = modifier
    )
}
