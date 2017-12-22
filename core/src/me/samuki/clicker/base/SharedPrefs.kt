package me.samuki.clicker.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Preferences


class SharedPrefs {
    var prefs: Preferences = Gdx.app.getPreferences(Constants.prefs.prefs_name)

    companion object {
        fun getInstance(): SharedPrefs = SharedPrefs()
    }

}