package com.example.myquotes.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.myquotes.data.Quote
import com.example.myquotes.data.QuoteRepo

class QuotesViewModel(private val quoteRepo: QuoteRepo):ViewModel() {
    fun getQuotes() = quoteRepo.getQuotes()

    fun addQuote(quote:Quote) = quoteRepo.addQuote(quote)

}
