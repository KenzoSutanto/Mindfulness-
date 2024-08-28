package com.kgscorp.mindfulness

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kgscorp.mindfulness.ui.theme.MindfulnessTheme
import com.kgscorp.mindfulness.ui.theme.interFontFamily

@ExperimentalMaterial3Api
@androidx.media3.common.util.UnstableApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MindfulnessTheme {
                val navController = rememberNavController()

                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavHost(navController = navController, startDestination = "mainScreen") {
                        composable("mainScreen") { MainScreenContent(navController) }
                        composable("Recommendation") {
                            Recommendations(navController = navController) {
                                navController.popBackStack()
                            }
                        }
                        // Add more composables for other destinations as needed
                    }
                }
            }
        }
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenContent(navController: NavHostController) {
    val backgroundColor = MaterialTheme.colorScheme.background

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(80.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(1f)
                    ) {
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
                        Spacer(modifier = Modifier.height(4.dp))
                        DynamicText(
                            text = "Settings",
                            backgroundColor = backgroundColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(1f)
                    ) {
                        IconButton(
                            onClick = { navController.navigate("mainScreen") },
                            modifier = Modifier.size(50.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "Home Page",
                                modifier = Modifier.size(45.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        DynamicText(
                            text = "Home",
                            backgroundColor = backgroundColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(1f)
                    ) {
                        IconButton(
                            onClick = { navController.navigate("library") }, // Assuming "library" is the correct route
                            modifier = Modifier.size(50.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = "Library",
                                modifier = Modifier.size(45.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        DynamicText(
                            text = "Library",
                            backgroundColor = backgroundColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                        )
                    }
                }
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),  // Padding to ensure content is not cut off by the bottom app bar
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                BiggerText(backgroundColor = backgroundColor)

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.navigate("Recommendations") },
                    modifier = Modifier.size(width = 350.dp, height = 160.dp),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        DynamicText(
                            text = "Recommendations",
                            backgroundColor = backgroundColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.navigate("Recommendations") },
                    modifier = Modifier.size(width = 350.dp, height = 160.dp),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        DynamicText(
                            text = "Saved Guides",
                            backgroundColor = backgroundColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
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
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    brush: Brush? = null // Add brush parameter
) {
    val textColor = getContrastingColor(backgroundColor)

    Text(
        text = text,
        color = if (brush == null) textColor else Color.Unspecified, // Use the brush if available, otherwise use textColor
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        modifier = modifier,
        style = TextStyle(brush = brush) // Apply the brush via style
    )
}

public var name = "Palaniii"

@Composable
fun BiggerText(backgroundColor: Color) {
    val rainbowBrush = Brush.linearGradient(
        colors = listOf(
            Color.Red,
            Color.Yellow,
            Color.Green,
            Color.Blue,
        )
    )

    // Build the AnnotatedString with different styles for "Hi," and "name"
    val text = buildAnnotatedString {
        append("Hi, ")

        withStyle(
            style = SpanStyle(
                brush = rainbowBrush,
                fontWeight = FontWeight.Bold,
                fontSize = 56.sp
            )
        ) {
            append(name)
        }
    }

    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(16.dp),
            style = TextStyle(
                color = getContrastingColor(backgroundColor),
                fontFamily = interFontFamily,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
        )
    }
}
