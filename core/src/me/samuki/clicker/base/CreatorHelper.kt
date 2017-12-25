package me.samuki.clicker.base

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.utils.Array


abstract class CreatorHelper {

        fun spriteCutting(texturePath: String, cols: Int, rows: Int, frameDuration: Float = 1F): Animation<TextureRegion> {
            val tmpTexture = Texture(texturePath)
            val tmp = TextureRegion.split(tmpTexture, tmpTexture.width / cols, tmpTexture.height / rows)
            val tmpFrames = Array<TextureRegion>()
            var index = 0
            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    tmpFrames.add(tmp[i][j])
                    index++
                }
            }
            return Animation<TextureRegion>(frameDuration, tmpFrames)
        }
}