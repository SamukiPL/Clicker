package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import me.samuki.clicker.CoreLauncher
import me.samuki.clicker.base.interfaces.communication.AndroidCommunicator


interface GameCommunicator {
    var isAdReady: Boolean
    var batch: SpriteBatch
    var camera: OrthographicCamera
    val androidCommunicator: AndroidCommunicator
    fun changeScreen(screenType: CoreLauncher.Companion.ScreenTypes)
}