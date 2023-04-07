package edu.temple.flossplayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel()
{
    private val _books = MutableLiveData<BookList>()
    val books: LiveData<BookList> get() = _books

    private val _selectedBook = MutableLiveData<Book>()
    val selectedBook: LiveData<Book> get() = _selectedBook

    private val _bookPlayerVisible = MutableLiveData<Boolean>()
    val bookPlayerVisible: LiveData<Boolean> get() = _bookPlayerVisible

    fun setBooks(books: BookList)
    {
        _books.value = books
    }

    fun selectBook(book: Book)
    {
        _selectedBook.value = book
    }

    fun setBookPlayerVisible(visible: Boolean)
    {
        _bookPlayerVisible.value = visible
    }
}