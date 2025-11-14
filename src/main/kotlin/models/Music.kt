package setu.ie.models

data class Music (
    val id: Int,
    val musicTitle: String,
    val musicArtist: String,
    val lengthInMins: Int,
    val releaseYear: Int,
    val genre: String,
    val isWrittenByArtist: Boolean,
    val numberOfPublicStreams: Int,
    val hasVideo: Boolean)