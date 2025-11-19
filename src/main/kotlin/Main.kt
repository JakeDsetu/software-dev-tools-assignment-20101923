package setu.ie
import setu.ie.controllers.ListenAPI
import setu.ie.controllers.MusicAPI
import setu.ie.models.Listen
import setu.ie.models.Music
import setu.ie.utils.isValidCategory
import setu.ie.utils.readNextBoolean
import setu.ie.utils.readNextInt
import setu.ie.utils.readNextLine
import java.lang.System.exit

private val musicAPI = MusicAPI()

fun main() {
    runMenu()
}

fun mainMenu(): Int {
    print("""
         > ----------------------------------
         > |           MUSIC APP            |
         > ----------------------------------
         > | MUSIC MENU                     |
         > |   1) Add a song                |
         > |   2) List all song             |
         > |   3) Update a song             |
         > |   4) Delete a song             |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > ==>> """.trimMargin(">"))
      return readNextInt(" > ==>>")
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1  -> addSong()
            0  -> exitApp()
            else -> println("Invalid option entered: $option")
        }
    } while (true)
}

fun addSong(){
    val id = readNextInt("Enter a song id:")
    val musicTitle = readNextLine("Enter the name of the song: ")
    val musicArtist = readNextLine("Enter the name of the artist: ")
    val lengthInMins = readNextInt("Enter the length (in minutes): ")
    val releaseYear = readNextInt("Enter the year of release: ")
    val genre = readNextLine("Enter the genre:")
    val isWrittenByArtist = readNextBoolean("Was the song written by the artist? True or false:")
    val numberOfPublicStreams = readNextInt("Enter the number of Public Listens:")
    val hasVideo = readNextBoolean("Does the song have a music video? True or false:")

    val isAdded = musicAPI.addMusic(Music(id, musicTitle, musicArtist, lengthInMins, releaseYear, genre, isWrittenByArtist, numberOfPublicStreams, hasVideo))

    if (isAdded) {
        println("Added Successfully")
    } else {
        println("Add Failed")
    }
}

fun exitApp() {
    println("Exiting...bye")
    exit(0)
}