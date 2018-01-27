package me.samuki.clicker.base


class Constants {

    class texts {
        companion object {
            const val ad_explanation_text = "Zobacz reklamę, aby\n zdobyć nagrodę.\n Czy zgadzasz się na\n wyświetlenie reklamy?"
            const val ad_yes_text = "Tak"
            const val ad_no_text = "Nie"
        }
    }

    class strings {
        companion object {
            const val actor_up: String = "up"
            const val actor_down: String = "down"
            const val actor_checked: String = "checked"
        }
    }

    class numbers {
        companion object {
            const val screen_width: Float = 768F
            const val screen_height: Float = 1366F
            const val pierdolce_cols: Int = 1
            const val pierdolce_rows: Int = 2
            const val instrument_width: Float = 192F
            const val instrument_height: Float = 120F
            const val instrument_base_price_multiplier: Float = 1.05F
            const val instrument_incrementation: Float = 0.075F
            const val numbers_before_shortening: Int = 6
            const val click_upgrade_divider: Int = 20
        }
    }

    class paths {
        companion object {
            const val basic_font: String = "fonts/font.fnt"
            const val no_image_found: String = "no_image.png"
            const val invisible_background: String = "invisible_background.png"
            const val click_income_invisible_texture: String = "textures/click_income_invisible_texture.png"
            const val base_upgrade_texture_path: String = "textures/upgrades/upgrade_" + replace_mark + ".png"
            //Main Screen
            private const val main_screen_path: String = "textures/mainscreen/"
            const val main_background: String = main_screen_path + "background.png"
            const val shop_icon: String = main_screen_path + "shop_icon.png"
            const val pierdolce: String = main_screen_path + "pierdolce.png"
            const val trombone: String = main_screen_path + "trombone.png"
            const val trumpet: String = main_screen_path + "Trumpet.png"
            const val flugelhorn: String = main_screen_path + "Flugelhorn.png"
            const val tuba: String = main_screen_path + "Tuba.png"
            const val saxophone: String = main_screen_path + "Saxophone.png"
            const val french_horn: String = main_screen_path + "French-Horn.png"
            const val sousaphone: String = main_screen_path + "Sousaphone.png"
            const val trembita: String = main_screen_path + "Trembita.png"
            const val sniper_rifle: String = main_screen_path + "jfk22nov63.png"
            const val shop_showcase_background: String = main_screen_path + "shop_showcase_background.png"
            const val show_shop_showcase: String = main_screen_path + "show_shop_showcase.png"
            const val hide_shop_showcase: String = main_screen_path + "hide_shop_showcase.png"
            const val cell_background: String = main_screen_path + "cell_background.png"
            const val rewarded_dialog_background: String = main_screen_path + "rewarded_dialog_background.png"
            //Shop Screen
            private const val shop_screen_path: String = "textures/shopscreen/"
            const val shop_background: String = shop_screen_path + "background.png"
            const val close_shop_icon: String = shop_screen_path + "close_icon.png"
        }
    }

    class prefs {
        companion object {
            const val prefs_name: String = "clicker_prefs"
            const val click_amount: String = "clicks_amount"
            const val amount: String = "amount"
            const val income: String = "income"
            const val click_income: String = "click_income"
            const val click_upgrades_bought: String = "click_upgrade_no_" + replace_mark
            const val click_upgrades_income: String = "click_upgrade_income" + replace_mark
            const val sounds_volume: String = "volume"
        }
    }

    companion object {
        const val replace_mark = "?"
        val upgrades_info: Array<ClickUpgrade> = arrayOf(
                ClickUpgrade("Puzon", Constants.paths.trombone, "100", "1"),
                ClickUpgrade("Trąbka", Constants.paths.trumpet, "5000", "10"),
                ClickUpgrade("Skrzydłówka", Constants.paths.flugelhorn, "50000", "100"),
                ClickUpgrade("Tuba", Constants.paths.tuba, "175000", "1000"),
                ClickUpgrade("Saksofon", Constants.paths.saxophone, "300000", "2500"),
                ClickUpgrade("Obój", Constants.paths.french_horn, "1000000", "5000"),
                ClickUpgrade("Suzafon", Constants.paths.sousaphone, "20000000", "10000"),
                ClickUpgrade("Trąbita", Constants.paths.trembita, "100000000", "25000"),
                ClickUpgrade("JFK 22NOV63", Constants.paths.sniper_rifle, "2000000000", "50000")
        )
        val money_makers: Array<MoneyMaker> = arrayOf(

        )
    }

    class ClickUpgrade(var name: String, var texturePath: String, var price: String, var clickIncome: String)
    class MoneyMaker(var name: String, var texturePath: String, var price: String, var income: String)
}