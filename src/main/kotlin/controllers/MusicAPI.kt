package setu.ie.controllers

import setu.ie.models.Music
import persistence.Serializer

class MusicAPI(serializerType: Serializer) {
    private var serializer: Serializer = serializerType

    private var songs = mutableListOf<Music>()

    private fun formatListString(notesToFormat : List<Music>) : String =
        notesToFormat
            .joinToString (separator = "\n") { note ->
                songs.indexOf(note).toString() + ": " + note.toString() }

    fun addMusic(music: Music) : Boolean {
        //code for adding a song with a unique id
        return songs.add(music)
    }

    fun listAllSongs(): String =
        if (songs.isEmpty()) "No songs stored"
        else formatListString(songs)

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