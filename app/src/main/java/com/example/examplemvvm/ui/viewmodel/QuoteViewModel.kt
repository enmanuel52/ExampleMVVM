package com.example.examplemvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.model.QuoteModel
import com.example.examplemvvm.data.model.QuoteProvider
import com.example.examplemvvm.domain.GetQuotesUseCase
import com.example.examplemvvm.domain.GetRandomQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    //encapsulo el modelo en un livedata
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuotesUseCase = GetRandomQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }

    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuotesUseCase()

        if(quote != null){
            quoteModel.postValue(quote)
        }

        isLoading.postValue(false)
    }
}