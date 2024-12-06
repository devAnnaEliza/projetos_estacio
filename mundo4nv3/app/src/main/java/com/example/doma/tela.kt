package com.example.doma

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Typography
import androidx.wear.compose.material.darkColors
import androidx.wear.compose.material.Shapes

@Composable
fun DomaVoiceTheme(
    content: @Composable () -> Unit
) {
    val colors = darkColors(
        primary = androidx.compose.ui.graphics.Color(0xFF6200EE),
        primaryVariant = androidx.compose.ui.graphics.Color(0xFF3700B3),
        secondary = androidx.compose.ui.graphics.Color(0xFF03DAC6)
    )

    val typography = Typography(
        defaultFontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
        h1 = androidx.compose.ui.text.TextStyle(
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontSize = androidx.compose.ui.unit.sp(24)
        ),
        body1 = androidx.compose.ui.text.TextStyle(
            fontSize = androidx.compose.ui.unit.sp(16)
        )
    )

    val shapes = Shapes(
        small = androidx.compose.foundation.shape.RoundedCornerShape(4.dp),
        medium = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
        large = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
