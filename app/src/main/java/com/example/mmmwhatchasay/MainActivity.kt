package com.example.mmmwhatchasay

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var mpSong: MediaPlayer
    private lateinit var mpGunshot: MediaPlayer
    private var songQueue = arrayOf<MediaPlayer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mpGunshot = MediaPlayer.create(this, R.raw.gunshot)
        mpSong = MediaPlayer.create(this, R.raw.mmmwhatchasay)
    }

    fun playSound(view: View) {
//        mpSong.stop()
//        mpGunshot.stop()
        mpGunshot = MediaPlayer.create(this, R.raw.gunshot)
        mpSong = MediaPlayer.create(this, R.raw.mmmwhatchasay)
        stopSound(view)
        mpGunshot.start()
        Thread.sleep(500)
        mpSong.start()
        songQueue += mpSong
        songQueue += mpGunshot
    }

    fun playContinuousSound(view: View) {
        mpGunshot = MediaPlayer.create(this, R.raw.gunshot)
        mpSong = MediaPlayer.create(this, R.raw.mmmwhatchasay)
        mpGunshot.start()
        Thread.sleep(500)
        mpSong.start()
        songQueue += mpSong
        songQueue += mpGunshot
    }

    fun stopSound(view: View) {
        for(song in songQueue) {
            song.stop()
        }
        songQueue = arrayOf<MediaPlayer>()
    }


}