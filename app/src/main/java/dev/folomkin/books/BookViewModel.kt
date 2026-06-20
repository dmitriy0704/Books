package dev.folomkin.books

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import java.util.concurrent.Executors

class BookViewModel(application: Application) : AndroidViewModel(BookApplication.instance) {
    private val db = BookDatabase.getInstance(getApplication())
    private val dao = db!!.bookDao()
    private val service = Executors.newFixedThreadPool(1)

    fun getAll(): LiveData<List<Book>> {
        return dao.getAll()
    }

    fun addBook(book: Book) {
        service.submit {
            dao.insert(book)
        }
    }
}