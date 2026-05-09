package com.elix.ai.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val conversationId: Int,

    val text: String,

    val isUser: Boolean,

    val timestamp: Long
)
