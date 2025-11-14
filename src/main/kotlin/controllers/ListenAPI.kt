package setu.ie.controllers

import setu.ie.models.Listen

class ListenAPI(private val musicAPI: MusicAPI) {
    private val listens = mutableListOf<Listen>()

    fun addListen(listen: Listen){
        //add code to validate that listenId and musicId exist
        //add code for adding a listen with a unique id
        listens.add(listen)
    }

    fun getAllListens(): List<Listen> = listens

    fun getListensByMusic(musicId: Int): List<Listen> =
        listens.filter { it.musicId == musicId }

    fun addListenToMusic(listenId: Int, musicId: Int) : String {
        val listen = listens.find { it.id == listenId }
        if (listen == null) {
            return "models.Listen with ID \${listenId} does not exist"
        } else if (musicAPI.musicExists(musicId) != null) {
            return "models.Music with ID \${musicId} does not exist."
        } else {
            listens[listens.indexOf(listen)] = listen.copy(musicId = musicId)
            return "models.Listen \${listen.name} moved to music ID \${musicId}."
        }
    }
}