package com.demokmp.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TecorbTheme(content: @Composable () -> Unit) {
    val colors = lightColorScheme(
        primary = Color(0xFF00C29D),
        onPrimary = Color.White,
        primaryContainer = Color(0xFFE0FFF6),
        onPrimaryContainer = Color(0xFF003229),
        secondary = Color(0xFF4A4F56),
        onSecondary = Color.White,
        background = Color(0xFFF6F7F9),
        onBackground = Color(0xFF1A1D1F),
        surface = Color.White,
        onSurface = Color(0xFF1A1D1F)
    )

    MaterialTheme(colorScheme = colors, content = content)
}

