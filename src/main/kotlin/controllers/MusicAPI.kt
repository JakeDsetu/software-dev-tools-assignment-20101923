package setu.ie.controllers

import setu.ie.models.Music

class MusicAPI {
    private val songs = mutableListOf<Music>()

    fun addMusic(music: Music) : Boolean {
        //code for adding a song with a unique id
        return songs.add(music)
    }

    fun getAllSongs(): List<Music> = songs

    fun musicExists(musicId: Int): Music? {
        return songs.find { it -> it.id == musicId }
    }
}