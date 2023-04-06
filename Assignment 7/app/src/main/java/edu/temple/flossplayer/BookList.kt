package edu.temple.flossplayer

class BookList
{
    private val library = ArrayList<Book>()

    fun add(book: Book)
    {
        library.add(book)
    }

    fun remove(book: Book)
    {
        library.remove(book)
    }

    fun get(index: Int): Book
    {
        return library[index]
    }

    fun size(): Int
    {
        return library.size
    }

    fun contains(book: Book): Boolean
    {
        return library.contains(book)
    }

    fun burn()
    {
        library.clear()
    }
}