package setu.ie.models

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