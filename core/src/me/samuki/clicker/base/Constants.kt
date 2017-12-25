package me.samuki.clicker.base

import me.samuki.clicker.models.UpgradeModel


class Constants {

    class texts {
        companion object {

        }
    }

    class strings {
        companion object {
            val actor_up: String = "up"
            val actor_down: String = "down"
            val actor_checked: String = "checked"
        }
    }

    class numbers {
        companion object {
            val screen_width: Float = 768F
            val screen_height: Float = 1366F
            val pierdolce_cols: Int = 1
            val pierdolce_rows: Int = 2
        }
    }

    class paths {
        companion object {
            val basic_font: String = "fonts/font.fnt"
            val no_image_found: String = "no_image.png"
            val click_income_invisible_texture: String = "textures/click_income_invisible_texture.png"
            val base_upgrade_texture_path: String = "textures/upgrades/upgrade_" + replace_mark + ".png"
            //Main Screen
            val main_screen_path: String = "textures/mainscreen/"
            val pierdolce: String = main_screen_path + "pierdolce.png"
            val trombone: String = main_screen_path + "trombone.png"
            val show_shop_showcase: String = main_screen_path + "show_shop_showcase.png"
            val hide_shop_showcase: String = main_screen_path + "hide_shop_showcase.png"
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