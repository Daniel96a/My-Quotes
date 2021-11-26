package com.example.myquotes.utils

import com.example.myquotes.data.FakeDatabase
import com.example.myquotes.data.QuoteRepo
import com.example.myquotes.ui.quotes.QuotesViewModelFactory

object InjectorUtil {

    fun providerQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepo = QuoteRepo.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepo)
    }
}