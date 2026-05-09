package com.elix.ai.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ChatDao {

    @Insert
    suspend fun insertConversation(
        conversation: Conversation
    ): Long

    @Insert
    suspend fun insertMessage(
        message: Message
    )

    @Query("SELECT * FROM conversations ORDER BY timestamp DESC")
    suspend fun getConversations(): List<Conversation>

    @Query("SELECT * FROM messages WHERE conversationId = :conversationId")
    suspend fun getMessages(
        conversationId: Int
    ): List<Message>
}
