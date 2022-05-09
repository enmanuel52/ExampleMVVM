package com.example.examplemvvm.data

import com.example.examplemvvm.data.database.dao.QuoteDao
import com.example.examplemvvm.data.database.entities.QuoteEntity
import com.example.examplemvvm.data.model.Quote
import com.example.examplemvvm.data.model.toDomain
import com.example.examplemvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao,
) {

    suspend fun getAllQuotesFromApi(): List<Quote>{
        val response = api.getQuotes()
        //data base :)
        return response.map{it -> it.toDomain()}
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote>{
        val response = quoteDao.getAllAQuotes()
        return response.map{it -> it.toDomain()}
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}