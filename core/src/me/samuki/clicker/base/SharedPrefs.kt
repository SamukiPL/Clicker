package me.samuki.clicker.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Preferences
import me.samuki.clicker.base.interfaces.BaseSingleton


class SharedPrefs {
    companion object : BaseSingleton<SharedPrefs> {
        private val INSTANCE: SharedPrefs = SharedPrefs()

        override fun getInstance(): SharedPrefs {
            return INSTANCE
        }
    }
    var prefs: Preferences = Gdx.app.getPreferences(Constants.prefs.prefs_name)


}