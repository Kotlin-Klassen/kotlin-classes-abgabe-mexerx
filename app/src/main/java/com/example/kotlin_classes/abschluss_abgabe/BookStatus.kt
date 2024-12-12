package com.example.kotlin_classes.abschluss_abgabe

/**
 * Book status
 *
 * @constructor Create empty Book status
 */
sealed class BookStatus {
    object Available : BookStatus()

    /**
     * Checked out
     *
     * @property dueDate
     * @constructor Create empty Checked out
     */
    data class CheckedOut(val dueDate: String) : BookStatus()

    /**
     * Reserved
     *
     * @property reservedBy
     * @constructor Create empty Reserved
     */
    data class Reserved(val reservedBy: String) : BookStatus()

    /**
     * Print status
     *
     */
    fun printStatus() {
        when (this) {
            is Available -> println("Available")
            is CheckedOut -> println("Checked Out, Due Date: $dueDate")
            is Reserved -> println("Reserved, Reserved By: $reservedBy")
        }
    }
}

