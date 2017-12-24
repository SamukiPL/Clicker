package me.samuki.clicker.base.interfaces

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch


interface GameCommunicator {
    var batch: SpriteBatch
    var camera: OrthographicCamera
}