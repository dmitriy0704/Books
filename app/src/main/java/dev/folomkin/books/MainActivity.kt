package dev.folomkin.books

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var list: RecyclerView
    private val books = mutableListOf<Book>()


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

        books.add(
            Book("Война и мир", "Лев Толстой", 33.44f, 4.4f)
        )
        books.add(
            Book("Идиот", "Достаевский", 34.45f, 4.5f)
        )
        books.add(
            Book("Палата № 6", "Достаевский", 32.42f, 4.2f)
        )
        books.add(
            Book("Шинель", "Гоголь", 34.40f, 4.3f)
        )
        books.add(
            Book("Онегин", "Пушкин", 43.43f, 4.7f)
        )

        books.add(
            Book("20 000 лье под водой", "Жюль Верн", 43.43f, 4.7f)
        )

        books.add(
            Book("Манифест коммунистической партии", "Карл Маркс", 43.43f, 4.7f)
        )

        books.add(
            Book("Онегин", "Пушкин", 43.43f, 4.7f)
        )

        books.add(
            Book("Шинель", "Гоголь", 34.40f, 4.3f)
        )

        val adapter = BooksAdapter(books)

        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, layout.orientation)
        list.layoutManager = layout
        list.addItemDecoration(decoration)
        list.adapter = adapter

    }
}