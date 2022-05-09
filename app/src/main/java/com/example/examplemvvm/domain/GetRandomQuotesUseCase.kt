package com.example.examplemvvm.domain

import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.model.Quote
import com.example.examplemvvm.data.model.QuoteModel
import javax.inject.Inject

class GetRandomQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository,
){

    //there is not coroutine because the data is in
    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }

        return null
    }
}