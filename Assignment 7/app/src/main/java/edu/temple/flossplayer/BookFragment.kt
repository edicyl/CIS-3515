package edu.temple.flossplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BookFragment : Fragment()
{
    private lateinit var bookTitle: TextView
    private lateinit var bookAuthor: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.fragment_book, container, false)

        bookTitle = view.findViewById(R.id.bookTitle)
        bookAuthor = view.findViewById(R.id.bookAuthor)

        return view
    }

    fun displayInfo(book: Book)
    {
        bookTitle.text = book.title
        bookAuthor.text = book.author
    }
}