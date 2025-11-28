package setu.ie.controllers

import persistence.Serializer
import setu.ie.models.Listen

/**
 * This class manages a list of listens and provides functionality for adding, updating, deleting,
 * and listing listens. It contains a serializer for storing listens, but it is only partially implemented.
 *
 * @property serializer A serializer instance for reading and writing listens.
 * @constructor Initializes the ListenAPI with the specified [serializerType].
 */
class ListenAPI(serializerType: Serializer) {
    private var serializer: Serializer = serializerType
    private var listens = mutableListOf<Listen>()

    /**
     * Function for adding a new listen to the database.
     * Returns true if the listen was added successfully, false otherwise.
     */
    fun addListen(listen: Listen): Boolean {
        return listens.add(listen)
    }

    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

    fun isValidIndex(index: Int): Boolean {
        return isValidListIndex(index, listens)
    }

    /**
     * Checks if a listen exists under a specified index, otherwise returns null.
     */
    fun findListen(index: Int): Listen? {
        return if (isValidListIndex(index, listens)) {
            listens[index]
        } else null
    }

    /**
     * Takes a music list and formats each song into a single string,
     * separating each song with a new line.
     */
    private fun formatListString(listenToFormat: List<Listen>): String =
        listenToFormat
            .joinToString(separator = "\n") { listen ->
                listens.indexOf(listen).toString() + ": " + listen.toString()
            }

    /**
     * Counts the number of listens currently in the database and returns the amount.
     */
    fun numberOfListens(): Int {
        return listens.size
    }

    /**
     * Checks if there are listens in the database. If there are, it formats them and returns them.
     */
    fun listAllListens(): String =
        if (listens.isEmpty()) "No listens stored"
        else formatListString(listens)

    /**
     * Updates an existing listen by asking the user to input a valid index, then reentering the details.
     * Returns true if successful, false otherwise.
     */
    fun updateListen(indexToUpdate: Int, listen: Listen): Boolean {
        val foundListen = findListen(indexToUpdate)

        if ((foundListen != null) && (listen != null)) {
            foundListen.musicId = listen.musicId
            foundListen.numMinsListenedTo = listen.numMinsListenedTo
            foundListen.listenRating = listen.listenRating
            foundListen.application = listen.application
            foundListen.timeOfDay = listen.timeOfDay
            return true
        }
        return false
    }

    /**
     * Checks if a listen exists and deletes it, otherwise returns null.
     */
    fun deleteListen(indexToDelete: Int): Listen? {
        return if (isValidListIndex(indexToDelete, listens)) {
            listens.removeAt(indexToDelete)
        } else null
    }
}
