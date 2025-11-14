package setu.ie
import setu.ie.controllers.ListenAPI
import setu.ie.controllers.MusicAPI
import setu.ie.models.Listen
import setu.ie.models.Music

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val musicAPI = MusicAPI()
    val listenAPI = ListenAPI(musicAPI)

    //adding sample music
    musicAPI.addMusic(Music(1, "Flowers", "Miley Cyrus", 3, 2023, "Pop", true, 3, 5000, true))
    musicAPI.addMusic(Music(2, "This Love", "Maroon 5", 3, 2002, "Pop", true, 2, 2000, true))

    //adding sample listens
    listenAPI.addListen(Listen(1, 1, 3, 5, "Spotify", 1030))
    listenAPI.addListen(Listen(2, 2, 2, 3, "Youtube", 1930))

    //adding listens to music
    listenAPI.addListenToMusic(1, 2)
    listenAPI.addListenToMusic(2, 1)

    //displaying all listens
    println("All Listens:")
    listenAPI.getAllListens().forEach { println(it) }

    //displaying all songs
    println("All Songs:")
    musicAPI.getAllSongs().forEach { println(it) }

    //Displaying listens by music
    println("\nListens in model.Music 1:")
    listenAPI.getListensByMusic(1).forEach { println(it) }

    //Displaying listens by music
    println("\nListens in model.Music 2:")
    listenAPI.getListensByMusic(2).forEach { println(it) }
}