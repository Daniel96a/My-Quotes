package com.example.myquotes.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myquotes.data.QuoteRepo

class QuotesViewModelFactory(private val quoteRepo: QuoteRepo): ViewModelProvider.NewInstanceFactory() {

    @Suppress(names = ["UNCHECKED_CAST"])
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepo) as T
    }
}