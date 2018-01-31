package me.samuki.clicker.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Preferences
import me.samuki.clicker.base.interfaces.BaseSingleton


class SharedPrefs private constructor() {
    companion object : BaseSingleton<SharedPrefs> {
        private val INSTANCE: SharedPrefs = SharedPrefs()

        override fun getInstance(): SharedPrefs {
            return INSTANCE
        }
    }

    var prefs: Preferences = Gdx.app.getPreferences(Constants.prefs.prefs_name)

    fun flush() {
        prefs.flush()
    }

    fun saveAmount(amount: String) {
        prefs.putString(Constants.prefs.amount, amount)
        flush()
    }

    fun saveIncome(income: String) {
        prefs.putString(Constants.prefs.income, income)
        flush()
    }

}