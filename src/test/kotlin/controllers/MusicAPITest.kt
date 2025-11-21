package controllers

import setu.ie.models.Music
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import persistence.XMLSerializer
import setu.ie.controllers.MusicAPI
import java.io.File
import kotlin.test.assertFalse

class MusicAPITest {

    private var WalkofFameMileyCyrus: Music? = null
    private var StormNightTapes: Music? = null
    private var ForeverNightTapes: Music? = null
    private var ImageMagBay: Music? = null
    private var SpotlightJessieWare: Music? = null
    private var populatedSongs: MusicAPI? = MusicAPI(XMLSerializer(File("songs.xml")))
    private var emptySongs: MusicAPI? = MusicAPI(XMLSerializer(File("empty-songs.xml")))

    @BeforeEach
    fun setup(){
        WalkofFameMileyCyrus = Music(1, "Walk of Fame", "Miley Cyrus", 6, 2025, "Pop", true, 12000000, true)
        StormNightTapes = Music(2, "Storm", "Night Tapes", 4, 2025, "Electronic", true, 1000000, true)
        ForeverNightTapes = Music(3, "Forever", "Night Tapes", 4, 2019, "Pop", true, 1200000, false)
        ImageMagBay = Music(4, "Image", "Magdalena Bay", 3, 2024, "Pop", true, 2000000, true)
        SpotlightJessieWare = Music(5, "Spotlight", "Jessie Ware", 6, 2020, "Pop", false, 3000000, true)

        populatedSongs!!.addMusic(WalkofFameMileyCyrus!!)
        populatedSongs!!.addMusic(StormNightTapes!!)
        populatedSongs!!.addMusic(ForeverNightTapes!!)
        populatedSongs!!.addMusic(ImageMagBay!!)
        populatedSongs!!.addMusic(SpotlightJessieWare!!)
    }

    @AfterEach
    fun tearDown(){
        WalkofFameMileyCyrus = null
        StormNightTapes = null
        ForeverNightTapes = null
        ImageMagBay = null
        SpotlightJessieWare = null
        populatedSongs = null
        emptySongs = null
    }

    @Nested
    inner class AddSongs {
        @Test
        fun `adding a Song to a populated list adds to ArrayList`() {
            val newSong = Music(6, "Cry for Me", "Magdalena Bay", 5, 2024, "Pop", true, 800000, false)
            assertEquals(5, populatedSongs!!.numberOfSongs())
            assertTrue(populatedSongs!!.addMusic(newSong))
            assertEquals(6, populatedSongs!!.numberOfSongs())
            assertEquals(newSong, populatedSongs!!.findSong(populatedSongs!!.numberOfSongs() - 1))
        }

        @Test
        fun `adding a Song to an empty list adds to ArrayList`() {
            val newSong = Music(6, "Cry for Me", "Magdalena Bay", 5, 2024, "Pop", true, 800000, false)
            assertEquals(0, emptySongs!!.numberOfSongs())
            assertTrue(emptySongs!!.addMusic(newSong))
            assertEquals(1, emptySongs!!.numberOfSongs())
            assertEquals(newSong, emptySongs!!.findSong(emptySongs!!.numberOfSongs() - 1))
        }
    }

    @Nested
    inner class ListSongs {
        @Test
        fun `listAllSongs returns No Songs Stored message when ArrayList is empty`() {
            assertEquals(0, emptySongs!!.numberOfSongs())
            assertTrue(emptySongs!!.listAllSongs().lowercase().contains("no songs"))
        }

        @Test
        fun `listAllSongs returns Songs with ArrayList has Songs stored`() {
            assertEquals(5, populatedSongs!!.numberOfSongs())
            val notesString = populatedSongs!!.listAllSongs().lowercase()
            assertTrue(notesString.contains("walk of fame"))
            assertTrue(notesString.contains("storm"))
            assertTrue(notesString.contains("forever"))
            assertTrue(notesString.contains("image"))
            assertTrue(notesString.contains("spotlight"))
        }
    }
}
