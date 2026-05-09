package com.elix.ai.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BrandLogo() {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF9C27B0),
                            Color(0xFFE040FB),
                            Color(0xFF7C4DFF)
                        )
                    )
                )
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "ELIX",

            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFD1B3FF)
                    )
                ),

                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 2.sp
            )
        )
    }
}
