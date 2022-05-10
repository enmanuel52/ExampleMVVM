package com.example.examplemvvm.data.model

import com.example.examplemvvm.data.database.entities.QuoteEntity

data class Quote(
    val quote: String,
    val author: String,
)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)
