package com.elix.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elix.ai.ui.components.MessageBubble

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ElixScreen()
        }
    }
}

@Composable
fun ElixScreen() {

    var text by remember {
        mutableStateOf("")
    }

    val messages = remember {
        mutableStateListOf<Pair<String, Boolean>>()
    }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0B0F1A))
                .padding(16.dp)
        ) {

            Text(
                text = "Elix AI",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                itemsIndexed(messages) { _, item ->

                    MessageBubble(
                        message = item.first,
                        isUser = item.second
                    )
                }
            }

            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                },

                modifier = Modifier.fillMaxWidth(),

                label = {
                    Text("Message Elix")
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {

                    if (text.isNotBlank()) {

                        messages.add(Pair(text, true))

                        messages.add(
                            Pair(
                                "I received: $text",
                                false
                            )
                        )

                        text = ""
                    }
                },

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("Send")
            }
        }
    }
}
