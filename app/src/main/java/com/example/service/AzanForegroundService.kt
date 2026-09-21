package com.example.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.MainActivity
import com.example.R
import kotlinx.coroutines.flow.MutableStateFlow

class AzanForegroundService : Service() {
    private var mediaPlayer: MediaPlayer? = null

    companion object {
        val isPlayingAzan = MutableStateFlow(false)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == "STOP_AZAN") {
            isPlayingAzan.value = false
            stopSelf()
            return START_NOT_STICKY
        }

        val azanName = intent?.getStringExtra("AZAN_NAME") ?: "Azan"
        
        createNotificationChannel()
        
        val stopIntent = Intent(this, AzanForegroundService::class.java).apply {
            action = "STOP_AZAN"
        }
        val stopPendingIntent = PendingIntent.getService(this, 0, stopIntent, PendingIntent.FLAG_IMMUTABLE)

        val mainIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("FROM_ALARM", true)
        }
        val mainPendingIntent = PendingIntent.getActivity(this, 0, mainIntent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(this, "azan_channel")
            .setContentTitle("It's time for $azanName")
            .setContentText("Azan is playing")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(mainPendingIntent)
            .setFullScreenIntent(mainPendingIntent, true)
            .addAction(R.mipmap.ic_launcher, "Stop", stopPendingIntent)
            .setOngoing(true)
            .build()
            
        startForeground(1, notification)

        playAzan()

        return START_NOT_STICKY
    }

    private fun playAzan() {
        if (mediaPlayer == null) {
            try {
                // Play authentic Azan audio from res/raw/azan.mp3
                mediaPlayer = MediaPlayer.create(this, R.raw.azan)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            if (mediaPlayer == null) {
                try {
                    val resId = resources.getIdentifier("azan", "raw", packageName)
                    if (resId != 0) {
                        mediaPlayer = MediaPlayer.create(this, resId)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            if (mediaPlayer == null) {
                try {
                    val alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
                    mediaPlayer = MediaPlayer.create(this, alarmUri)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            // User requirement: Play once and then close
            mediaPlayer?.let { player ->
                player.isLooping = false
                isPlayingAzan.value = true

                player.setOnCompletionListener {
                    isPlayingAzan.value = false
                    stopSelf()
                }

                player.setOnErrorListener { _, _, _ ->
                    isPlayingAzan.value = false
                    stopSelf()
                    true
                }

                try {
                    player.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                    isPlayingAzan.value = false
                    stopSelf()
                }
            } ?: run {
                isPlayingAzan.value = false
                stopSelf()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isPlayingAzan.value = false
        try {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.stop()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "azan_channel",
                "Azan Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Azan audio playback service"
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
}
