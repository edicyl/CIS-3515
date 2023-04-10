package edu.temple.flossplayer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity()
{
    private lateinit var bookList: BookList
    private lateinit var bookViewModel: BookViewModel
    private var isLand: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call function to generate 10 books
        bookList = generateBookList(this)

        // Create the ViewModel and set the book list
        bookViewModel = ViewModelProvider(this)[BookViewModel::class.java]
        bookViewModel.setBooks(bookList)

        isLand = findViewById<View>(R.id.displayBookPlayer) != null

        // Check if the screen is in landscape mode
        if (savedInstanceState == null) {
            if (isLand) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.displayBookList, BookListFragment())
                    .replace(R.id.displayBookPlayer, BookPlayerFragment())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, BookListFragment())
                    .commit()
            }
        }
    }

    // Generate the list of books from the string resources
    private fun generateBookList(context: Context): BookList
    {
        val bookList = BookList()
        val bookTitles = context.resources.getStringArray(R.array.book_titles)
        val bookAuthors = context.resources.getStringArray(R.array.book_authors)

        for (i in bookTitles.indices)
        {
            bookList.add(Book(bookTitles[i], bookAuthors[i]))
        }

        return bookList
    }
}