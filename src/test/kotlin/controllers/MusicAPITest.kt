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

    @Nested
    inner class DeleteSongs {

        @Test
        fun `deleting a Song that does not exist, returns null`() {
            assertNull(emptySongs!!.deleteSong(0))
            assertNull(populatedSongs!!.deleteSong(-1))
            assertNull(populatedSongs!!.deleteSong(5))
        }

        @Test
        fun `deleting a song that exists delete and returns deleted object`() {
            assertEquals(5, populatedSongs!!.numberOfSongs())
            assertEquals(SpotlightJessieWare, populatedSongs!!.deleteSong(4))
            assertEquals(4, populatedSongs!!.numberOfSongs())
            assertEquals(WalkofFameMileyCyrus, populatedSongs!!.deleteSong(0))
            assertEquals(3, populatedSongs!!.numberOfSongs())
        }
    }

    @Nested
    inner class UpdateNotes {
        @Test
        fun `updating a song that does not exist returns false`(){
            assertFalse(populatedSongs!!.updateSong(6, Music(6, "Cry for Me", "Magdalena Bay", 5, 2024, "Pop", true, 800000, false)))
            assertFalse(populatedSongs!!.updateSong(-1, Music(6, "Cry for Me", "Magdalena Bay", 5, 2024, "Pop", true, 800000, false)))
            assertFalse(emptySongs!!.updateSong(0, Music(6, "Cry for Me", "Magdalena Bay", 5, 2024, "Pop", true, 800000, false)))
        }

        @Test
        fun `updating a song that exists returns true and updates`() {

            assertEquals(SpotlightJessieWare, populatedSongs!!.findSong(4))
            assertEquals(5, populatedSongs!!.findSong(4)!!.id)
            assertEquals("Spotlight", populatedSongs!!.findSong(4)!!.musicTitle)
            assertEquals("Jessie Ware", populatedSongs!!.findSong(4)!!.musicArtist)
            assertEquals(6, populatedSongs!!.findSong(4)!!.lengthInMins)
            assertEquals(2020, populatedSongs!!.findSong(4)!!.releaseYear)
            assertEquals("Pop", populatedSongs!!.findSong(4)!!.genre)
            assertEquals(false, populatedSongs!!.findSong(4)!!.isWrittenByArtist)
            assertEquals(3000000, populatedSongs!!.findSong(4)!!.numberOfPublicStreams)
            assertEquals(true, populatedSongs!!.findSong(4)!!.hasVideo)


            assertTrue(populatedSongs!!.updateSong(4, Music(5, "Pearls", "Jessie Ware", 4, 2022, "Pop", false, 2000000, true)))
            assertEquals(5, populatedSongs!!.findSong(4)!!.id)
            assertEquals("Pearls", populatedSongs!!.findSong(4)!!.musicTitle)
            assertEquals("Jessie Ware", populatedSongs!!.findSong(4)!!.musicArtist)
            assertEquals(4, populatedSongs!!.findSong(4)!!.lengthInMins)
            assertEquals(2022, populatedSongs!!.findSong(4)!!.releaseYear)
            assertEquals("Pop", populatedSongs!!.findSong(4)!!.genre)
            assertEquals(false, populatedSongs!!.findSong(4)!!.isWrittenByArtist)
            assertEquals(2000000, populatedSongs!!.findSong(4)!!.numberOfPublicStreams)
            assertEquals(true, populatedSongs!!.findSong(4)!!.hasVideo)
        }
    }
}
