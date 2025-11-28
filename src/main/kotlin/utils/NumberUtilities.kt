package setu.ie.utils

/**
 * Checks if a number is within a valid range of numbers.
 */
fun validRange(numberToCheck: Int, min: Int, max: Int): Boolean {
    return numberToCheck in min..max
}
