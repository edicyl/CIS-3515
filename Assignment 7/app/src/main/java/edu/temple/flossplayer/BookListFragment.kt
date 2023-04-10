package edu.temple.flossplayer

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookListFragment : Fragment()
{
    private lateinit var viewModel: BookViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookListAdapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[BookViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.bookList.observe(viewLifecycleOwner) { bookList ->
            bookListAdapter = BookListAdapter(bookList.getLibrary()) { book ->
                viewModel.selectBook(book)

                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, BookPlayerFragment())
                        .addToBackStack(null)
                        .commit()
                }
            }

            recyclerView.adapter = bookListAdapter
        }
    }
}