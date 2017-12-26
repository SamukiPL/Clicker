package me.samuki.clicker.base


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
            val trumpet: String = main_screen_path + "trombone.png"
            val trombone: String = main_screen_path + "trombone.png"
            val shop_showcase_background: String = main_screen_path + "shop_showcase_background.png"
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
            val click_upgrades_bought: String = "click_upgrade_no_" + replace_mark
            val sounds_volume: String = "volume"
        }
    }

    companion object {
        val replace_mark = "?"
        val upgrades_info: Array<ClickUpgrade> = arrayOf(
            ClickUpgrade("Trąbka", Constants.paths.trumpet),
            ClickUpgrade("Puzon", Constants.paths.trombone)
        )
    }

    class ClickUpgrade(var name: String, var texturePath: String)
}