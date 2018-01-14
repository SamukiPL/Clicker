package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import me.samuki.clicker.CoreLauncher


interface GameCommunicator {
    var batch: SpriteBatch
    var camera: OrthographicCamera
    fun changeScreen(screenType: CoreLauncher.Companion.ScreenTypes)
}