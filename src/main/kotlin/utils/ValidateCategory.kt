package setu.ie.utils

val categories = setOf("Pop", "Rock", "Hip-Hop", "Dance", "Electronic", "Country")

/**
 * Checks that an entered string falls under a specified list of categories.
 */
fun isValidCategory(categoryToCheck: String?): Boolean {
    for (category in categories) {
        if (category.equals(categoryToCheck, ignoreCase = true)) {
            return true
        }
    }
    return false
}
