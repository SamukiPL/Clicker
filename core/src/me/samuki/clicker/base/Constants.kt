package me.samuki.clicker.base

import me.samuki.clicker.models.UpgradeModel


class Constants {
    class strings {
        companion object {

        }
    }

    class numbers {
        companion object {
            val screen_width: Float = 768F
            val screen_height: Float = 1366F
        }
    }

    class paths {
        companion object {
            val no_image_found: String = "no_image.png"
            val base_upgrade_texture_path: String = "textures/upgrades/upgrade_" + replace_mark + ".png"
        }
    }

    class prefs {
        companion object {
            val prefs_name: String = "clicker_prefs"
            val amount: String = "amount"
            val income: String = "income"
            val click_income: String = "click_income"
            val upgrades_bought: String = "upgrade_no_" + replace_mark
            val sounds_volume: String = "volume"
        }
    }

    companion object {
        val replace_mark = "?"
        val upgrades_info: Array<Upgrade> = arrayOf(
            Upgrade("Trąbka", 1),
            Upgrade("Puzon", 5)
        )
    }

    class Upgrade(var name: String, var income: Int)
}