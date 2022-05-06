package com.example.examplemvvm.data

import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import com.example.examplemvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider,
) {

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        //data base :)
        quoteProvider.quotes = response
        return response
    }
}