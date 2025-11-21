package setu.ie.models

data class Listen (
    val id: Int,
    var musicId: Int,
    var numMinsListenedTo: Int,
    var listenRating: Int,
    var application: String,
    var timeOfDay: Int
)