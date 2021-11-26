package com.example.myquotes.data

class QuoteRepo private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object{
        @Volatile private var instance: QuoteRepo? = null

        fun getInstance(quoteDao: FakeQuoteDao) = instance ?: synchronized(this){
            instance ?: QuoteRepo(quoteDao).also {  instance = it }
        }
    }
}