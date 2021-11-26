package com.example.myquotes.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.data.Quote
import com.example.myquotes.utils.InjectorUtil
import kotlinx.android.synthetic.main.activity_quotes.*
import myquotes.R

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUI(quotes_recycler_view)
    }

    private fun initializeUI(recyclerView: RecyclerView){
        val factory = InjectorUtil.providerQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this,factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer{ quotes ->
            recyclerView.adapter = QuoteItemAdapter(this, quotes)
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}

