package setu.ie.models

/**
 * A data class for storing music/songs:
 * id: the id of the song
 * musicTitle: the name of the song
 * musicArtist: the name of the main artist of the song.
 * lengthInMins: the length of the song in minutes.
 * releaseYear: what year the song released.
 * genre: the genre of the song (Pop, Rock, Electronic, etc.).
 * isWrittenByArtist: checks if the main artist is credited as a writer of the song.
 * numberOfPublicStreams: How many streams does the song have from other people publicly.
 * hasVideo: checks if the song has a music video or not.
 */
data class Music (
    val id: Int,
    var musicTitle: String,
    var musicArtist: String,
    var lengthInMins: Int,
    var releaseYear: Int,
    var genre: String,
    var isWrittenByArtist: Boolean,
    var numberOfPublicStreams: Int,
    var hasVideo: Boolean)