package com.example.examplemvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "quote_table")
data class QuoteEntity(
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name ="author") val author: String,
)