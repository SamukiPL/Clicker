package me.samuki.clicker.base

import me.samuki.clicker.base.interfaces.BaseSingleton
import me.samuki.clicker.base.interfaces.SoundsPlayer


class SoundsManager : SoundsPlayer {
    companion object : BaseSingleton<SoundsPlayer> {
        val INSTANCE: SoundsPlayer = SoundsManager()

        override fun getInstance(): SoundsPlayer {
            return INSTANCE
        }
    }

    override var volume: Float = SharedPrefs.getInstance().prefs.getFloat(Constants.prefs.sounds_volume)

    init {
        initSounds()
    }

    private fun initSounds() {

    }

}