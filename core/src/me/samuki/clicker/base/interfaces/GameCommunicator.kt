package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch


interface GameCommunicator {
    val batch: SpriteBatch
    val camera: OrthographicCamera
}