package com.example.examplemvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() { //modelo
        var quotes: List<QuoteModel> = emptyList()
}