package setu.ie.controllers

import setu.ie.models.Music
import persistence.Serializer

class MusicAPI(serializerType: Serializer) {
    private var serializer: Serializer = serializerType

    private var songs = mutableListOf<Music>()

    private fun formatListString(musicToFormat : List<Music>) : String =
        musicToFormat
            .joinToString (separator = "\n") { music ->
                songs.indexOf(music).toString() + ": " + music.toString() }

    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

    fun isValidIndex(index: Int) :Boolean{
        return isValidListIndex(index, songs);
    }

    fun findSong(index: Int): Music? {
        return if (isValidListIndex(index, songs)) {
            songs[index]
        } else null
    }

    fun addMusic(music: Music) : Boolean {
        //code for adding a song with a unique id
        return songs.add(music)
    }

    fun numberOfSongs(): Int {
        return songs.size
    }

    fun listAllSongs(): String =
        if (songs.isEmpty()) "No songs stored"
        else formatListString(songs)

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

        //if the song was not found, return false, indicating that the update was not successful
        return false
    }

    fun deleteSong(indexToDelete: Int): Music? {
        return if (isValidListIndex(indexToDelete, songs)) {
            songs.removeAt(indexToDelete)
        } else null
    }

    fun musicExists(musicId: Int): Music? {
        return songs.find { it -> it.id == musicId }
    }

    @Throws(Exception::class)
    fun load() {
        songs = serializer.read() as ArrayList<Music>
    }

    @Throws(Exception::class)
    fun store() {
        serializer.write(songs)
    }
}