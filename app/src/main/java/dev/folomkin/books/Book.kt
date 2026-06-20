package dev.folomkin.books

import androidx.room.Entity


@Entity(tableName = "book", primaryKeys = ["title", "author"])
data class Book(
    var title: String,
    var author: String,
    var price: Float,
    var rating: Float
)