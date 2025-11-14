package setu.ie.models

data class Listen (
    val id: Int,
    val musicId: Int,
    val numMinsListenedTo: Int,
    val listenRating: Int,
    val application: String,
    val timeOfDay: Int
)