package controllers

import setu.ie.models.Listen
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import persistence.XMLSerializer
import setu.ie.controllers.ListenAPI
import setu.ie.models.Music
import java.io.File
import kotlin.test.assertFalse

class ListenAPITest {

    private var WalkofFameListen: Listen? = null
    private var StormListen: Listen? = null
    private var StormListen2: Listen? = null
    private var ImageListen: Listen? = null
    private var SpotlightListen: Listen? = null
    private var populatedListens: ListenAPI? = ListenAPI(XMLSerializer(File("listens.xml")))
    private var emptyListens: ListenAPI? = ListenAPI(XMLSerializer(File("empty-listens.xml")))

    @BeforeEach
    fun setup(){
        WalkofFameListen = Listen(1, 1, 6, 5, "Spotify", 1200)
        StormListen = Listen(2, 2, 4, 5, "Youtube", 1100)
        StormListen2 = Listen(3, 2, 3, 4, "Youtube", 1110)
        ImageListen = Listen(4, 4, 3, 5, "Spotify", 1800)
        SpotlightListen = Listen(5, 5, 0, 1, "Deezer", 1900)

        populatedListens!!.addListen(WalkofFameListen!!)
        populatedListens!!.addListen(StormListen!!)
        populatedListens!!.addListen(StormListen2!!)
        populatedListens!!.addListen(ImageListen!!)
        populatedListens!!.addListen(SpotlightListen!!)
    }

}