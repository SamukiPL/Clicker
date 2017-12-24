package me.samuki.clicker.base

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation


abstract class CreatorHelper {

        fun spriteCutting(texturePath: String, cols: Int, rows: Int): Animation<Array<TextureRegion?>> {
            val tmpTexture = Texture(texturePath)
            val tmp = TextureRegion.split(tmpTexture, tmpTexture.width / cols, tmpTexture.height / rows)
            val tmpFrames = arrayOfNulls<TextureRegion>(cols * rows)
            var index = 0
            for (i in 0 until rows) {
                for (j in 0 until cols) {
                    tmpFrames[index] = tmp[i][j]
                    index++
                }
            }
            return Animation(1f, tmpFrames)
        }
}