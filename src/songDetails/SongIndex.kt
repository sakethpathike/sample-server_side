package com.saketh.sample.songDetails

data class SongIndex(
    var songName: String?,
    var albumName: String?,
    var spotifyLink: String?,
    var youtubeMusicVideoLink: String = "Ahuga Kachubi??",
    var albumArt: String?,
    var tinyAlbumArt: String?
)