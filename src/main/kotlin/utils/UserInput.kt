package setu.ie.utils

/**
 * Checks that the user enters an Integer.
 */
fun readNextInt(prompt: String?): Int {
    do {
        try {
            print(prompt)
            return readln().toInt()
        } catch (e: NumberFormatException) {
            System.err.println("\tEnter a number please.")
        }
    } while (true)
}

/**
 * Checks that the user enters a Boolean.
 */
fun readNextBoolean(prompt: String?): Boolean {
    do {
        try {
            print(prompt)
            return readln().toBoolean()
        } catch (e: NumberFormatException) {
            System.err.println("\tAnswer True or False.")
        }
    } while (true)
}

/**
 * Checks that the user enters a line of text.
 */
fun readNextLine(prompt: String?): String {
    print(prompt)
    return readln()
}
