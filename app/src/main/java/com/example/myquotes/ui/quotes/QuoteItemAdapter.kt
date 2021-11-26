package com.example.myquotes.ui.quotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.data.Quote
import myquotes.R


class QuoteItemAdapter(
    private val context: Context,
    private val dataset: List<Quote>
): RecyclerView.Adapter<QuoteItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val itemQuoteTextTextView: TextView = view.findViewById(R.id.item_quoteText)
        val authorTextView: TextView = view.findViewById(R.id.item_author)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.quote_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemQuoteTextTextView.text = item.quoteText
        holder.authorTextView.text = item.author
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}
