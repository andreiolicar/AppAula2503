package com.example.appaula2503.ui.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Paleta Minimalista
val DarkGrey = Color(0xFF2D2D2D)
val LightSurface = Color(0xFFF8F9FA)
val BorderColor = Color(0xFFE0E0E0)

// Tons Pastel para as Notas
val PastelRed = Color(0xFFFFB3BA)    // Nota I
val PastelOrange = Color(0xFFFFDFBA) // Nota R
val PastelBlue = Color(0xFFBAE1FF)   // Nota B
val PastelGreen = Color(0xFFBAFFC9)  // Nota MB

@Composable
fun errorButtonColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = PastelRed,
    contentColor = Color(0xFF442C2E)
)

@Composable
fun warningButtonColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = PastelOrange,
    contentColor = Color(0xFF443B2C)
)

@Composable
fun debugButtonColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = PastelBlue,
    contentColor = Color(0xFF2C3544)
)

@Composable
fun infoButtonColors(): ButtonColors = ButtonDefaults.buttonColors(
    containerColor = PastelGreen,
    contentColor = Color(0xFF2C4430)
)
