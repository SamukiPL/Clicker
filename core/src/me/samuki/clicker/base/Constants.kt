package me.samuki.clicker.base

import me.samuki.clicker.models.UpgradeModel


class Constants {
    class strings {
        companion object {

        }
    }

    class numbers {
        companion object {

        }
    }

    class paths {
        companion object {
            val no_image_found: String = "no_image.png"
            val base_upgrade_texture_parh = "upgrades/upgrade_" + replace_mark + ".png"
        }
    }

    class prefs {
        companion object {
            val prefs_name: String = "clicker_prefs"
            val upgrades_bought = "upgrade_no_" + replace_mark
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