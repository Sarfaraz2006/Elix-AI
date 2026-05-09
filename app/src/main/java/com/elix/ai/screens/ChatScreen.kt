package com.elix.ai.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen(
    goBack: () -> Unit
) {

    var text by remember {
        mutableStateOf("")
    }

    val messages = remember {
        mutableStateListOf<Pair<String, Boolean>>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B1020))
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = goBack
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Text(
                text = "Elix Chat",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(messages) { item ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                    if (item.second)
                        Arrangement.End
                    else
                        Arrangement.Start
                ) {

                    Card(
                        modifier = Modifier
                            .padding(vertical = 4.dp),

                        colors = CardDefaults.cardColors(
                            containerColor =
                            if (item.second)
                                Color(0xFFBB86FC)
                            else
                                Color(0xFF1C1C1C)
                        ),

                        shape = RoundedCornerShape(18.dp)
                    ) {

                        Text(
                            text = item.first,
                            color = Color.White,
                            modifier = Modifier.padding(14.dp)
                        )
                    }
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = text,

                onValueChange = {
                    text = it
                },

                modifier = Modifier.weight(1f),

                placeholder = {
                    Text("Type message")
                }
            )

            Spacer(modifier = Modifier.width(10.dp))

            FloatingActionButton(
                onClick = {

                    if (text.isNotBlank()) {

                        messages.add(
                            Pair(text, true)
                        )

                        messages.add(
                            Pair(
                                "Elix received: $text",
                                false
                            )
                        )

                        text = ""
                    }
                },

                containerColor = Color(0xFFBB86FC)
            ) {

                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null
                )
            }
        }
    }
}
