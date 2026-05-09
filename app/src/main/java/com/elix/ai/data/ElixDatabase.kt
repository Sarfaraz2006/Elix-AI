package com.elix.ai.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Conversation::class,
        Message::class
    ],

    version = 1
)

abstract class ElixDatabase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}
