package setu.ie.controllers

import persistence.Serializer
import setu.ie.models.Listen

class ListenAPI(serializerType: Serializer) {
    private var serializer: Serializer = serializerType

    private var listens = mutableListOf<Listen>()

    fun addListen(listen: Listen): Boolean {
        return listens.add(listen)
    }

    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

    fun isValidIndex(index: Int): Boolean {
        return isValidListIndex(index, listens)
    }

    fun findListen(index: Int): Listen? {
        return if (isValidListIndex(index, listens)) {
            listens[index]
        } else null
    }

    private fun formatListString(listenToFormat: List<Listen>): String =
        listenToFormat
            .joinToString(separator = "\n") { listen ->
                listens.indexOf(listen).toString() + ": " + listen.toString()
            }

    fun numberOfListens(): Int {
        return listens.size
    }

    fun listAllListens(): String =
        if (listens.isEmpty()) "No listens stored"
        else formatListString(listens)

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

    fun deleteListen(indexToDelete: Int): Listen? {
        return if (isValidListIndex(indexToDelete, listens)) {
            listens.removeAt(indexToDelete)
        } else null
    }
}
