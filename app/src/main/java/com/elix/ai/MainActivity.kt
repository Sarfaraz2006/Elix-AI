package com.elix.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
        mutableStateListOf<String>()
    }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0F1115))
                .padding(16.dp)
        ) {

            Text(
                text = "Elix",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(messages) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = it,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }

            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Talk to Elix")
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {

                    if (text.isNotBlank()) {

                        messages.add("You: $text")
                        messages.add("Elix: I received your message")

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
