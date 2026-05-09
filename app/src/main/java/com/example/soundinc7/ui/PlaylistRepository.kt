package com.example.soundinc7.ui

import com.example.soundinc7.ui.models.Playlist
import com.example.soundinc7.ui.models.Song
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object PlaylistRepository{
    private val _playlists = MutableStateFlow(
        listOf(
            Playlist(1,"Favourites","Blues",15,"#E91E63", true),
            Playlist(2, "Pop Hits", "Pop", 20, "#2196F3",false),
            Playlist(3, "Hip Hop Jams", "Hip Hop", 12, "#FFC107",false),
            Playlist(4, "Indie Radio", "Indie", 8, "#4CAF50",false),
            Playlist(5, "Classical Music", "Classical", 18, "#9C27B0",false),
            Playlist(6, "Metal Covers", "Metal", 25, "#F44336",false)
        )
    )

    val songs = listOf(
        Song(1, "Grand Avenue", "Mike Zito", 276, 1),
        Song(2, "Blinding Lights", "The Weeknd", 200, 2),
        Song(3, "HUMBLE.", "Kendrick Lamar", 177, 3),
        Song(4, "Do I Wanna Know?", "Arctic Monkeys", 272, 4),
        Song(5, "Moonlight Sonata", "Beethoven", 337, 5),
        Song(6, "Master of Puppets", "Metallica", 515, 6)
    )

    val playlist : StateFlow<List<Playlist>> = _playlists.asStateFlow()

    fun toggleFavorite(playlist: Playlist){
        _playlists.value = _playlists.value.map{
            if (it.id == playlist.id){
                it.copy(isFavorite = !it.isFavorite)
            } else {
                it
            }
        }
    }

    fun deletePlaylist(playlist: Playlist){
        _playlists.value = _playlists.value.filter { it.id != playlist.id }
    }
}