package edu.temple.flossplayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel()
{
    private val _bookList = MutableLiveData<BookList>()
    val bookList: LiveData<BookList> get() = _bookList

    private val _selectedBook = MutableLiveData<Book>()
    val selectedBook: LiveData<Book> get() = _selectedBook

    fun setBooks(books: BookList)
    {
        _bookList.value = books
    }

    fun selectBook(book: Book)
    {
        _selectedBook.value = book
    }
}