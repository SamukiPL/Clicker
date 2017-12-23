package me.samuki.clicker.base

import me.samuki.clicker.base.interfaces.SoundsPlayer


class SoundsManager : SoundsPlayer {
    companion object {
        val INSTANCE: SoundsPlayer = SoundsManager()

        fun getInstance(): SoundsPlayer {
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