package edu.temple.flossplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity()
{
    private lateinit var bookList: BookList

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instance of BookList class
        bookList = BookList()

        // Create a list of 10 book titles
        val bookTitles = arrayOf(
            "The Catcher in the Rye",
            "1984",
            "To Kill a Mockingbird",
            "Animal Farm",
            "The Great Gatsby",
            "Pride and Prejudice",
            "The Lord of the Rings",
            "The Hobbit",
            "Harry Potter and the Philosopher's Stone",
            "The Da Vinci Code"
        )

        // Create a list of those 10 authors
        val bookAuthors = arrayOf(
            "J.D. Salinger",
            "George Orwell",
            "Harper Lee",
            "George Orwell",
            "F. Scott Fitzgerald",
            "Jane Austen",
            "J.R.R. Tolkien",
            "J.R.R. Tolkien",
            "J.K. Rowling",
            "Dan Brown"
        )

        // Add the books to BookList
        for (i in bookTitles.indices)
        {
            bookList.add(Book(bookTitles[i], bookAuthors[i]))
        }
    }
}