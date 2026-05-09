package com.elix.ai.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MessageBubble(
    message: String,
    isUser: Boolean
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement =
        if (isUser) Arrangement.End
        else Arrangement.Start
    ) {

        Box(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .background(
                    color =
                    if (isUser)
                        Color(0xFF7E57C2)
                    else
                        Color(0xFF1E1E1E),

                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp)
        ) {

            Text(
                text = message,
                color = Color.White
            )
        }
    }
}
