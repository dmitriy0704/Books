package dev.folomkin.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BooksAdapter(val books: List<Book>) : RecyclerView.Adapter<BookHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.book, parent, false)
        return BookHolder(view)
    }

    override fun onBindViewHolder(
        holder: BookHolder,
        position: Int
    ) {
        val book = books[position]
        holder.bind(book)
    }
    override fun getItemCount(): Int {
        return books.size
    }

}