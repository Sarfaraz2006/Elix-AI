package com.elix.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.elix.ai.screens.ChatScreen
import com.elix.ai.screens.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var currentScreen by remember {
                mutableStateOf("home")
            }

            when(currentScreen) {

                "home" -> {

                    HomeScreen(
                        openChat = {
                            currentScreen = "chat"
                        }
                    )
                }

                "chat" -> {

                    ChatScreen(
                        goBack = {
                            currentScreen = "home"
                        }
                    )
                }
            }
        }
    }
}
