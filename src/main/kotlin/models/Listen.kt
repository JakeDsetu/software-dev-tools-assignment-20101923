package setu.ie.models

/**
 * A data class for storing listens:
 * id: the id of the listen
 * musicId: the id of the song the listen is tied to.
 * numMinsListenedTo: The amount of time listened to the song (out of the total length).
 * listenRating: How much of the song was listened to (from 0 to 5, 0 being almost none, 5 being all).
 * application: the application used to listen to the song (Spotify, Youtube, Deezer, etc.).
 * timeOfDay: the time of day the listen happened (formatted in 24-hour time, e.g. 1300 = 1PM).
 */
data class Listen (
    val id: Int,
    var musicId: Int,
    var numMinsListenedTo: Int,
    var listenRating: Int,
    var application: String,
    var timeOfDay: Int
)