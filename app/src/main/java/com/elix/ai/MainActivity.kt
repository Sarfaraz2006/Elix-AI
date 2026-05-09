package com.elix.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elix.ai.ui.BrandLogo

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ElixApp()
        }
    }
}

@Composable
fun ElixApp() {

    var message by remember {
        mutableStateOf("")
    }

    var showSidebar by remember {
        mutableStateOf(false)
    }

    val messages = remember {
        mutableStateListOf<Pair<String, Boolean>>()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF050816),
                            Color(0xFF091126),
                            Color(0xFF050816)
                        )
                    )
                )
                .pointerInput(Unit) {

                    detectHorizontalDragGestures { _, dragAmount ->

                        if (dragAmount > 20) {
                            showSidebar = true
                        }

                        if (dragAmount < -20) {
                            showSidebar = false
                        }
                    }
                }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),

                    verticalAlignment = Alignment.CenterVertically,

                    horizontalArrangement =
                    Arrangement.SpaceBetween
                ) {

                    BrandLogo()

                    IconButton(
                        onClick = {
                            showSidebar = !showSidebar
                        }
                    ) {

                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Good Evening",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Sarfaraz",
                    color = Color(0xFFB388FF),
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {

                    items(messages.size) { index ->

                        val item = messages[index]

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
                                    .padding(vertical = 6.dp),

                                colors = CardDefaults.cardColors(
                                    containerColor =
                                    if (item.second)
                                        Color(0xFF9C27B0)
                                    else
                                        Color(0xFF161B22)
                                ),

                                shape = RoundedCornerShape(20.dp)
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
                        value = message,

                        onValueChange = {
                            message = it
                        },

                        modifier = Modifier.weight(1f),

                        placeholder = {
                            Text("Ask Elix anything...")
                        },

                        shape = RoundedCornerShape(30.dp),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFB388FF),
                            unfocusedBorderColor = Color.DarkGray,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    FloatingActionButton(
                        onClick = {

                            if (message.isNotBlank()) {

                                messages.add(
                                    Pair(message, true)
                                )

                                messages.add(
                                    Pair(
                                        "Elix AI response for: $message",
                                        false
                                    )
                                )

                                message = ""
                            }
                        },

                        containerColor = Color(0xFFB026FF)
                    ) {

                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    FloatingActionButton(
                        onClick = {},

                        containerColor = Color(0xFFE040FB)
                    ) {

                        Icon(
                            imageVector = Icons.Default.Mic,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }

        if (showSidebar) {

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(260.dp)
                    .background(Color(0xFF111827))
                    .padding(20.dp)
            ) {

                Column {

                    Spacer(modifier = Modifier.height(40.dp))

                    BrandLogo()

                    Spacer(modifier = Modifier.height(30.dp))

                    SidebarItem("History")
                    SidebarItem("Image AI")
                    SidebarItem("Automation")
                    SidebarItem("Voice Mode")
                    SidebarItem("Settings")
                }
            }
        }
    }
}

@Composable
fun SidebarItem(
    title: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1F2E)
        )
    ) {

        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}
