package me.samuki.clicker.main

import com.badlogic.gdx.Preferences
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.main.interfaces.MainDataManager
import java.math.BigInteger


class MainDataManagerImpl : MainDataManager {
    private lateinit var prefs: Preferences

    init {
        initPrefs()
    }

    override fun initPrefs() {
        prefs = SharedPrefs.getInstance().prefs
    }

    override fun loadTextures() {

    }

    override fun getTextures() {

    }

    override fun loadTexts() {

    }

    override fun getTexts() {

    }

    override fun getClickIncomeString(): String {
        return prefs.getString(Constants.prefs.click_income, "0")
    }
}