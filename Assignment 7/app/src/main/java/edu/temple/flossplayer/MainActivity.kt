package edu.temple.flossplayer

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity()
{
    private lateinit var bookList: BookList
    private lateinit var bookViewModel: BookViewModel
    private var isLand: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instance of BookList class
        bookList = BookList()

        // Create a list of books and authors
        val bookData = listOf(
            Pair("The Catcher in the Rye", "J.D. Salinger"),
            Pair("To Kill a Mockingbird", "Harper Lee"),
            Pair("Pride and Prejudice", "Jane Austen"),
            Pair("1984", "George Orwell"),
            Pair("The Great Gatsby", "F. Scott Fitzgerald"),
            Pair("Brave New World", "Aldous Huxley"),
            Pair("The Hobbit", "J.R.R. Tolkien"),
            Pair("Moby-Dick", "Herman Melville"),
            Pair("The Odyssey", "Homer"),
            Pair("The Grapes of Wrath", "John Steinbeck")
        )

        // Add the books to BookList
        for (book in bookData)
        {
            bookList.add(Book(book.first, book.second))
        }

        bookViewModel = ViewModelProvider(this)[BookViewModel::class.java]
        bookViewModel.setBooks(bookList)

        isLand = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        if (savedInstanceState == null)
        {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            if (isLand)
            {
                fragmentTransaction.replace(R.id.displayBookList, BookListFragment())
                fragmentTransaction.replace(R.id.displayBookPlayer, BookPlayerFragment())
            }

            else
            {
                if (bookViewModel.bookPlayerVisible.value == true)
                {
                    fragmentTransaction.replace(R.id.displaySingle, BookPlayerFragment())
                }

                else
                {
                    fragmentTransaction.replace(R.id.displaySingle, BookListFragment())
                }
            }

            fragmentTransaction.commit()
        }
    }
}