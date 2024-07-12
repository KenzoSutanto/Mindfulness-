package com.kgscorp.mindfulness

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kgscorp.mindfulness.ui.theme.MindfulnessTheme
import com.kgscorp.mindfulness.ui.theme.interFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindfulnessTheme {
                val backgroundColor = MaterialTheme.colorScheme.background
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Box() {
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