package me.samuki.clicker.models

import com.badlogic.gdx.graphics.Texture
import me.samuki.clicker.base.Constants


class UpgradeModel(
        var index: Int,
        var name: String = "",
        var amount: Int = 0,
        var income: Int = 0,
        var texturePath: String = Constants.paths.no_image_found) {
    lateinit var texture: Texture

    fun initTexture() {
        texture = Texture(texturePath)
    }

    fun dispose() {
        texture.dispose()
    }

    fun refreshAmount(amount: Int) {
        this.amount = amount
    }

}