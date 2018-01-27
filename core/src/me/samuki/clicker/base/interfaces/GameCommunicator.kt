package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import me.samuki.clicker.CoreLauncher
import me.samuki.clicker.base.interfaces.communication.AndroidAdsCommunicator


interface GameCommunicator {
    var batch: SpriteBatch
    var camera: OrthographicCamera
    val androidAdsCommunicator: AndroidAdsCommunicator
    fun changeScreen(screenType: CoreLauncher.Companion.ScreenTypes)
}