package setu.ie.utils

//utility method to determine if an index is valid in a list.
fun isValidListIndex(index: Int, list: List<Any>): Boolean {
    return (index >= 0 && index < list.size)
}