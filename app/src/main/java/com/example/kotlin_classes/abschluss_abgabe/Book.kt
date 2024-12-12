package com.example.kotlin_classes.abschluss_abgabe

/**
 * Book
 *
 * @property title
 * @property author
 * @property genre
 * @property status
 * @constructor Create empty Book
 */
data class Book(
    val title: String,
    val author: String,
    val genre: Genre,
    var status: BookStatus

)
