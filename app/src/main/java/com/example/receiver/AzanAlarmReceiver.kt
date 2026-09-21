package com.example.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.service.AzanForegroundService

class AzanAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val azanName = intent.getStringExtra("AZAN_NAME") ?: return
        Log.d("AzanAlarmReceiver", "Received alarm for $azanName")
        
        val serviceIntent = Intent(context, AzanForegroundService::class.java).apply {
            putExtra("AZAN_NAME", azanName)
        }
        
        // Start Foreground Service
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            context.startForegroundService(serviceIntent)
        } else {
            context.startService(serviceIntent)
        }
    }
}
