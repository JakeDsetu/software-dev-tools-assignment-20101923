package setu.ie.controllers

import persistence.Serializer
import setu.ie.models.Music

/**
 * This class manages a list of songs and provides functionality for adding, updating, deleting,
 * and listing songs. It contains a serializer for storing songs, but it is only partially implemented.
 *
 * @property serializer A serializer instance for reading and writing songs.
 * @constructor Initializes the MusicAPI with the specified [serializerType].
 */
class MusicAPI(serializerType: Serializer) {
    private var serializer: Serializer = serializerType
    private var songs = mutableListOf<Music>()

    /**
     * Takes a music list and formats each song into a single string,
     * separating each song with a new line.
     */
    private fun formatListString(musicToFormat: List<Music>): String =
        musicToFormat
            .joinToString(separator = "\n") { music ->
                songs.indexOf(music).toString() + ": " + music.toString()
            }

    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

    fun isValidIndex(index: Int): Boolean {
        return isValidListIndex(index, songs)
    }

    /**
     * Checks if a song exists under a specified index, otherwise returns null.
     */
    fun findSong(index: Int): Music? {
        return if (isValidListIndex(index, songs)) {
            songs[index]
        } else null
    }

    /**
     * Function for adding a new song to the database.
     * Returns true if the song was added successfully, false otherwise.
     */
    fun addMusic(music: Music): Boolean {
        return songs.add(music)
    }

    /**
     * Counts the number of songs currently in the database and returns the amount.
     */
    fun numberOfSongs(): Int {
        return songs.size
    }

    /**
     * Checks if there are songs in the database. If there are, it formats them and returns them.
     */
    fun listAllSongs(): String =
        if (songs.isEmpty()) "No songs stored"
        else formatListString(songs)

    /**
     * Updates an existing song by asking the user to input a valid index, then reentering the details.
     * Returns true if successful, false otherwise.
     */
    fun updateSong(indexToUpdate: Int, music: Music?): Boolean {
        val foundSong = findSong(indexToUpdate)

        if ((foundSong != null) && (music != null)) {
            foundSong.musicTitle = music.musicTitle
            foundSong.musicArtist = music.musicArtist
            foundSong.lengthInMins = music.lengthInMins
            foundSong.releaseYear = music.releaseYear
            foundSong.genre = music.genre
            foundSong.isWrittenByArtist = music.isWrittenByArtist
            foundSong.numberOfPublicStreams = music.numberOfPublicStreams
            foundSong.hasVideo = music.hasVideo
            return true
        }

        return false
    }

    /**
     * Checks if a song exists and deletes it, otherwise returns null.
     */
    fun deleteSong(indexToDelete: Int): Music? {
        return if (isValidListIndex(indexToDelete, songs)) {
            songs.removeAt(indexToDelete)
        } else null
    }
}
