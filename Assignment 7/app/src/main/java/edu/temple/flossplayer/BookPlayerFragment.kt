package edu.temple.flossplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class BookPlayerFragment : Fragment()
{
    private lateinit var viewModel: BookViewModel
    private var bookFragment: BookFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[BookViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        val view = inflater.inflate(R.layout.fragment_book_player, container, false)

        if (savedInstanceState == null) {
            bookFragment = BookFragment()
            childFragmentManager.beginTransaction()
                .add(R.id.bookFragmentFrame, bookFragment!!)
                .commit()
        }

        return view
    }
}