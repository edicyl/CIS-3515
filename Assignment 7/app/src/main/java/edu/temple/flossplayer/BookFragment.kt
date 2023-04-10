package edu.temple.flossplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class BookFragment : Fragment()
{
    private lateinit var viewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[BookViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleTextView: TextView = view.findViewById(R.id.bookTitle)
        val authorTextView: TextView = view.findViewById(R.id.bookAuthor)

        viewModel.selectedBook.observe(viewLifecycleOwner) { book ->
            titleTextView.text = book.title
            authorTextView.text = book.author
        }
    }
}