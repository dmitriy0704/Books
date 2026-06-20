package dev.folomkin.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.rangeTo
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var list: RecyclerView

    //    private val books = mutableListOf<Book>()
    private lateinit var adapter: BooksAdapter
    private lateinit var model: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list)) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        list = findViewById(R.id.list)
        model = ViewModelProvider(this).get(BookViewModel::class.java)
        model.getAll().observe(this, Observer<List<Book>> {
            val a = BooksAdapter(it)
            list.adapter = a
        })


        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, layout.orientation)
        list.layoutManager = layout
        list.addItemDecoration(decoration)

        // Инициализируем Toolbar для работы меню
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.myToolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_add -> {
                showAddDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showAddDialog() {
        val view = LayoutInflater
            .from(this)
            .inflate(R.layout.add_book_dialog, null)
        val title = view.findViewById<EditText>(R.id.title)
        val author = view.findViewById<EditText>(R.id.author)
        val price = view.findViewById<EditText>(R.id.price)
        val rating = view.findViewById<RatingBar>(R.id.rating)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        builder.setTitle("Create a book")
        builder.setNegativeButton("Cansel") { dialog, _ ->
            dialog.cancel()
        }
        builder.setPositiveButton("Create") { dialog, _ ->
            val book = Book(
                title.text.toString(),
                author.text.toString(),
                price.text.toString().toFloat(),
                rating.rating
            )
            model.addBook(book)
//            adapter.notifyItemInserted(0)
//            adapter.notifyDataSetChanged()
            dialog.dismiss()

        }

        builder.create().show()
    }
}