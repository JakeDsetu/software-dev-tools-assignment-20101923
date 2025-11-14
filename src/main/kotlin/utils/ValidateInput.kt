package setu.ie.utils

fun readValidCategory(prompt: String?): String {
    var input = readNextLine(prompt)
    do {
        if (isValidCategory(input))
            return input
        else {
            print("Invalid category $input.  Please try again: ")
            input = readNextLine(prompt)
        }
    } while (true)
}

fun readValidPriority(prompt: String?): Int {
    var input = readNextInt(prompt)
    do {
        if (validRange(input, 1, 5))
            return input
        else {
            print("Invalid priority $input.")
            input = readNextInt(prompt)
        }
    } while (true)
}