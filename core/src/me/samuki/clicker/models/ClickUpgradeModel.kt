package me.samuki.clicker.models

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import com.badlogic.gdx.utils.Align
import me.samuki.clicker.base.*
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.main.interfaces.MainListeners


class ClickUpgradeModel(
        val id: Int,
        val listeners: MainListeners
) : BaseModel() {
    override var type: ModelTypes = ModelTypes.CLICK_UPGRADE_MODEL

    var amount: Long = 0L
    lateinit var price: String

    var amountActor: Actor? = null
    var priceActor: Actor? = null

    fun getUpgradeWidgetGroup(): WidgetGroup {
        val name: String = Constants.upgrades_info[id].name
        val path: String = Constants.upgrades_info[id].texturePath
        amount = SharedPrefs.getInstance().prefs.getLong(Constants.prefs.click_upgrades_bought.replace(Constants.replace_mark, id.toString()), 0L)
        price = getPrice(id, amount, Constants.upgrades_info[id].price)

        val group = WidgetGroup()

        group.addActor(ActorModel(ActorModel.Companion.ActorTypes.BUTTON_TYPE, Constants.paths.showcase_cell_background,
                boundX = Constants.numbers.screen_width, boundY = 200F).getActorFromModel())
        //IMAGE
        group.addActor(ActorModel(ActorModel.Companion.ActorTypes.BUTTON_TYPE, path,
                boundX = Constants.numbers.instrument_width, boundY = Constants.numbers.instrument_height,
                positionY = 200F - Constants.numbers.instrument_height, positionX = 20F,
                listener = listeners.buyClickUpgrade(this)).getActorFromModel())
        //NAME TEXT
        group.addActor(ActorModel(ActorModel.Companion.ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.click_income_invisible_texture,
                Constants.paths.click_income_invisible_texture, buttonText = name, textScale = 0.45F,
                boundX = Constants.numbers.screen_width - Constants.numbers.instrument_width, textAlign = Align.center,
                boundY = Constants.numbers.instrument_height, positionX = 240F,
                positionY = 80F,listener = listeners.buyClickUpgrade(this)).getActorFromModel())
        //AMOUNT TEXT
        amountActor = ActorModel(ActorModel.Companion.ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.click_income_invisible_texture,
                Constants.paths.click_income_invisible_texture, buttonText = "Kup", textAlign = Align.right, textScale = 0.45F,
                boundX = 80F, boundY = 80F, positionX = 490F, positionY = 10F,listener = listeners.buyClickUpgrade(this)).getActorFromModel()
        group.addActor(amountActor)
        //PRICE TEXT
        priceActor = ActorModel(ActorModel.Companion.ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.click_income_invisible_texture,
                Constants.paths.click_income_invisible_texture, buttonText = price.toString(),
                boundX = Constants.numbers.instrument_width, boundY = 80F, textAlign = Align.left,
                textScale = 0.5F, positionX = 50F, positionY = 8F,listener = listeners.buyClickUpgrade(this)).getActorFromModel()
        group.addActor(priceActor)

        return group
    }

    fun checkIfBuyingIsPossible(): Boolean {
        return false
    }

    fun handelBuying() {
        val id = id
        val amount: Long = incrementAmount()
        val price: String = incrementPrice()
        SharedPrefs.getInstance().prefs.putLong(
                Constants.prefs.click_upgrades_bought.replace(Constants.replace_mark,
                        id.toString()), amount)
        SharedPrefs.getInstance().flush()
        (amountActor as TextButton).setText(amount.toString())
        (priceActor as TextButton).setText(price)

        ClickUpgradesHandlerImpl.getInstance().handleClickUpgrade(id, amount - 1)
    }

    private fun incrementAmount(): Long {
        amount++
        return amount
    }

    private fun incrementPrice(): String {
        price = getPriceAfterUpgrading(price)
        return price
    }

    private fun getPrice(id: Int, amount: Long, basePrice: String): String {
        val priceString = BasicMethods.shortenNumber(basePrice)
        var abbreviation: String = ""
        var priceNumber: Double = 0.0
        if (priceString.contains(" ")) {
            abbreviation = priceString.substring(priceString.indexOf(" ", 0, true), priceString.length)
            priceNumber = priceString.removeRange(priceString.indexOf(" ", 0, true), priceString.length).toDouble()
        } else {
            priceNumber = priceString.toDouble()
        }
        var x = 0
        while (x < amount) {
            priceNumber = ((priceNumber * (Constants.numbers.instrument_base_price_multiplier + (Constants.numbers.instrument_incrementation * (id + 1)))) +
                    (priceNumber * (x / 90))).toDouble()
            x++
        }
        return BasicMethods.shortenNumberWithAbbreviation(priceNumber, abbreviation)
    }

    private fun getPriceAfterUpgrading(price: String): String {
        var abbreviation: String = ""
        var priceNumber: Double = 0.0
        if (price.contains(" ")) {
            abbreviation = price.substring(price.indexOf(" ", 0, true), price.length)
            priceNumber = price.removeRange(price.indexOf(" ", 0, true), price.length).toDouble()
        } else {
            priceNumber = price.toDouble()
        }
        priceNumber = ((priceNumber * (Constants.numbers.instrument_base_price_multiplier + (Constants.numbers.instrument_incrementation * (id + 1)))) +
                (priceNumber * (amount / 90))).toDouble()

        return BasicMethods.shortenNumberWithAbbreviation(priceNumber, abbreviation)
    }
}