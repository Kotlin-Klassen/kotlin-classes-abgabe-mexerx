package com.example.kotlin_classes.abschluss_abgabe

/**
 * Genre
 *
 * @property description
 * @constructor Create empty Genre
 */
enum class Genre(val description: String)  {
    /**
     * Fiction
     *
     * @constructor Create empty Fiction
     */
    FICTION("Fictional stories and novels"),

    /**
     * Non Fiction
     *
     * @constructor Create empty Non Fiction
     */
    NON_FICTION("Non-fiction books"),

    /**
     * Science
     *
     * @constructor Create empty Science
     */
    SCIENCE("Science fiction and fantasy"),

    /**
     * History
     *
     * @constructor Create empty History
     */
    HISTORY("Historical fiction"),

    /**
     * Children
     *
     * @constructor Create empty Children
     */
    CHILDREN("Children's books");

    /**
     * Print description
     *
     */
    fun printDescription() {
        println(description)
    }
}
