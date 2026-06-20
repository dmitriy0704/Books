package dev.folomkin.books

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg books: Book)

    @Delete
    fun delete(vararg books: Book)

    @Query("select * from book")
    fun getAll(): LiveData<List<Book>>

}