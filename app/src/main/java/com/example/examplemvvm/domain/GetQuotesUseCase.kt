package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.database.entities.toDatabase
import com.example.examplemvvm.data.model.Quote
import com.example.examplemvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private  val repository: QuoteRepository
){
    suspend operator fun invoke(): List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){ //if true insert to database
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it -> it.toDatabase() })
            quotes
        } else{
            repository.getAllQuotesFromDatabase()
        }
    }
}