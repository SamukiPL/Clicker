package me.samuki.clicker.main

import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.main.interfaces.MainDataManager


class MainDataManagerImpl : MainDataManager {
    lateinit var prefs: SharedPrefs

    init {
        initPrefs()
    }

    override fun initPrefs() {
        prefs = SharedPrefs.getInstance()
    }

    override fun loadTextures() {

    }

    override fun getTextures() {

    }

    override fun loadTexts() {

    }

    override fun getTexts() {

    }
}