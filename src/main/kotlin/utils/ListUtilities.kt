package setu.ie.utils

/**
 * Utility to check if the index in a list is valid.
 */
fun isValidListIndex(index: Int, list: List<Any>): Boolean {
    return (index >= 0 && index < list.size)
}
