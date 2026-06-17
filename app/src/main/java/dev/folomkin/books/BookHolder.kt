package dev.folomkin.books

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title: TextView = itemView.findViewById(R.id.titleBook)
    var author: TextView = itemView.findViewById(R.id.author)
    var rating: RatingBar = itemView.findViewById(R.id.ratingBar)
    var price: TextView = itemView.findViewById(R.id.price)

    fun bind(book: Book) {
        title.text = book.title
        author.text = book.author
        rating.rating = book.rating
        price.text = "${book.price}"
    }
}