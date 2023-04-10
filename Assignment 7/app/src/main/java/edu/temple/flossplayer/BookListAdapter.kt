package edu.temple.flossplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookListAdapter(private val bookList: List<Book>, private val onBookClick: (Book) -> Unit) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {
    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.bookTitle)
        val author: TextView = itemView.findViewById(R.id.bookAuthor)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onBookClick(bookList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_book, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.title.text = book.title
        holder.author.text = book.author
    }

    override fun getItemCount(): Int = bookList.size
}
