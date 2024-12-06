package com.example.doma

import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioManager

class audio(private val context: Context) {
    private val audioManager: AudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    fun audioOutputAvailable(type: Int): Boolean {
        return if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_AUDIO_OUTPUT)) {
            audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS).any { it.type == type }
        } else {
            false
        }
    }
}
