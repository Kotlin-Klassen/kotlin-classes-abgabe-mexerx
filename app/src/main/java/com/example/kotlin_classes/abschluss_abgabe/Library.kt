package com.example.kotlin_classes.abschluss_abgabe

/**
 * Library
 *
 * @constructor Create empty Library
 */
class Library {
    private val books: MutableList<Book> = mutableListOf()

    /**
     * Library address
     *
     * @property street
     * @property city
     * @property zipCode
     * @constructor Create empty Library address
     */
    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        /**
         * Print address
         *
         */
        fun printAddress() {
            println("$street, $city, $zipCode")
        }
    }

    /**
     * Library member
     *
     * @property name
     * @property memberID
     * @constructor Create empty Library member
     */
    inner class LibraryMember(val name: String, val memberID: Int) {
        /**
         * Checkout book
         *
         * @param book
         * @param dueDate
         */
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status == BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out '${book.title}' due on $dueDate.")
            } else {
                println("Book '${book.title}' is not available for checkout.")
            }
        }

        /**
         * Reserve book
         *
         * @param book
         */
        fun reserveBook(book: Book) {
            if (book.status == BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved '${book.title}'.")
            } else {
                println("Book '${book.title}' is not available for reservation.")
            }
        }
    }

    /**
     * Add book
     *
     * @param book
     */
    fun addBook(book: Book) {
        books.add(book)
    }

    /**
     * Search book by title or author
     *
     * @param query
     * @return List<Book>
     */
    fun searchBook(query: String): List<Book> {
        return books.filter { it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true) }
    }

    /**
     * Print book status
     *
     */
    fun printBookStatus() {
        books.forEach {
            println("Title: ${it.title}, Author: ${it.author}, Status: ")
            it.status.printStatus()
        }
    }
}

/**
 * Main
 *
 */
fun main() {
    val library = Library()
    library.addBook(Book("The Lord of the Rings", "J.R.R. Tolkien", Genre.FICTION, BookStatus.Available))
    library.addBook(Book("Sapiens", "Yuval Noah Harari", Genre.NON_FICTION, BookStatus.Available))
    library.addBook(Book("The Alchemist", "Paulo Coelho", Genre.FICTION, BookStatus.Available))
    library.addBook(Book("The Da Vinci Code", "Dan Brown", Genre.FICTION, BookStatus.Available))
    library.addBook(Book("The Hunger Games", "Suzanne Collins", Genre.CHILDREN, BookStatus.Available))
    library.addBook(Book("The Kite Runner", "Khaled Hosseini", Genre.HISTORY, BookStatus.Available))
    library.addBook(Book("The Book Thief", "Markus Zusak", Genre.CHILDREN, BookStatus.Available))
    library.addBook(Book("The Chronicles of Narnia", "C.S. Lewis", Genre.CHILDREN, BookStatus.Available))
    library.addBook(Book("The Fault in Our Stars", "John Green", Genre.FICTION, BookStatus.Available))
    library.addBook(Book("The Human Body", "Richard Dawkins", Genre.SCIENCE, BookStatus.Available))
    library.addBook(Book("The Martian", "Andy Weir", Genre.SCIENCE, BookStatus.Available))


    val libraryAddress = Library.LibraryAddress("123 Main St", "Anytown", "12345")
    println("   Library Address:")
    libraryAddress.printAddress()
    println("\n")


    println(" Library Members:")
    val member = library.LibraryMember("Alice", 1234)
    val member2 = library.LibraryMember("Bob", 5678)
    println(" Member: ${member.name} (ID: ${member.memberID})")
    println(" Member: ${member2.name} (ID: ${member2.memberID})")
    println("\n")

    println("   Book Status:")
    library.printBookStatus()
    println("\n")

    println("   Checkout and Reservation:")

    member.checkoutBook(library.searchBook("Lord of the Rings")[0], "2024-01-15")
    member.reserveBook(library.searchBook("Sapiens")[0])
    member.checkoutBook(library.searchBook("The Alchemist")[0], "2023-12-31")
    member.reserveBook(library.searchBook("The Da Vinci Code")[0])

    member2.checkoutBook(library.searchBook("The Book Thief")[0], "2024-02-28")
    member2.reserveBook(library.searchBook("The Da Vinci Code")[0])


    println("\n")

    println("   Updated Book Status:")
    library.printBookStatus()

}