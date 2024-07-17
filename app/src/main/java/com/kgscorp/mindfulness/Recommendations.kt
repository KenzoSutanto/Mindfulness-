package com.kgscorp.mindfulness

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Recommendations(navController: NavHostController, onBackClick: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DynamicText(
            text = "Recommendations",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black, // Default color specified here
            modifier = Modifier.padding(vertical = 8.dp)
        )
        // Example buttons 1 to 4
        Button(
            onClick = { navController.navigate("destination_route/Example 1") },
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
                    text = "Example 1",
                    backgroundColor = backgroundColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("destination_route/Example 2") },
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
                    text = "Example 2",
                    backgroundColor = backgroundColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("destination_route/Example 3") },
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
                    text = "Example 3",
                    backgroundColor = backgroundColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("destination_route/Example 4") },
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
                    text = "Example 4",
                    backgroundColor = backgroundColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
val backgroundColor = Color.Red // Replace with your actual color

@Composable
fun DynamicText(
    text: String,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    color: Color = Color.Black,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val textColor = getContrastingColor(backgroundColor)
    Text(
        text = text,
        color = textColor,
        fontWeight = fontWeight,
        fontSize = fontSize,
        modifier = modifier
    )
}