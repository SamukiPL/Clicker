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
            val instrument_width: Float = 192F
            val instrument_height: Float = 120F
            val instrument_base_price_multiplier: Float = 1.05F
            val instrument_incrementation: Float = 0.075F
            val numbers_before_shortening: Int = 6
            val click_upgrade_divider: Int = 20
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
            val main_background: String = main_screen_path + "background.png"
            val pierdolce: String = main_screen_path + "pierdolce.png"
            val trombone: String = main_screen_path + "trombone.png"
            val trumpet: String = main_screen_path + "Trumpet.png"
            val flugelhorn: String = main_screen_path + "Flugelhorn.png"
            val tuba: String = main_screen_path + "Tuba.png"
            val saxophone: String = main_screen_path + "Saxophone.png"
            val french_horn: String = main_screen_path + "French-Horn.png"
            val sousaphone: String = main_screen_path + "Sousaphone.png"
            val trembita: String = main_screen_path + "Trembita.png"
            val sniper_rifle: String = main_screen_path + "jfk22nov63.png"
            val shop_showcase_background: String = main_screen_path + "shop_showcase_background.png"
            val show_shop_showcase: String = main_screen_path + "show_shop_showcase.png"
            val hide_shop_showcase: String = main_screen_path + "hide_shop_showcase.png"
            val cell_background: String = main_screen_path + "cell_background.png"
        }
    }

    class prefs {
        companion object {
            val prefs_name: String = "clicker_prefs"
            val click_amount: String = "clicks_amount"
            val amount: String = "amount"
            val income: String = "income"
            val click_income: String = "click_income"
            val click_upgrades_bought: String = "click_upgrade_no_" + replace_mark
            val click_upgrades_income: String = "click_upgrade_income" + replace_mark
            val sounds_volume: String = "volume"
        }
    }

    companion object {
        val replace_mark = "?"
        val upgrades_info: Array<ClickUpgrade> = arrayOf(
                ClickUpgrade("Puzon", Constants.paths.trombone, "100", "1"),
                ClickUpgrade("Trąbka", Constants.paths.trumpet, "1000", "10"),
                ClickUpgrade("Skrzydłówka", Constants.paths.flugelhorn, "50000", "100"),
                ClickUpgrade("Tuba", Constants.paths.tuba, "100000", "1000"),
                ClickUpgrade("Saksofon", Constants.paths.saxophone, "250000", "2500"),
                ClickUpgrade("Obój", Constants.paths.french_horn, "500000", "5000"),
                ClickUpgrade("Suzafon", Constants.paths.sousaphone, "1000000", "10000"),
                ClickUpgrade("Trąbita", Constants.paths.trembita, "2500000", "25000"),
                ClickUpgrade("JFK 22NOV63", Constants.paths.sniper_rifle, "5000000", "50000")
        )
    }

    class ClickUpgrade(var name: String, var texturePath: String, var price: String, var clickIncome: String)
}