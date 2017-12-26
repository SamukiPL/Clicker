package me.samuki.clicker.models

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import me.samuki.clicker.base.BaseModel
import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.main.interfaces.MainListeners
import java.math.BigInteger


class ClickUpgradeModel(
        val id: Int,
        val listeners: MainListeners
) : BaseModel() {
    override var type: ModelTypes = ModelTypes.CLICK_UPGRADE_MODEL

    lateinit var amount: BigInteger
    lateinit var price: BigInteger

    var amountActor: Actor? = null
    var priceActor: Actor? = null

    fun getUpgradeWidgetGroup(): WidgetGroup {
        val name: String = Constants.upgrades_info[id].name
        val path: String = Constants.upgrades_info[id].texturePath
        amount = BigInteger(SharedPrefs.getInstance().prefs.getString(Constants.prefs.click_upgrades_bought.replace(Constants.replace_mark, id.toString()), "0"))
        price = BigInteger(getPrice(id, amount.toLong()))

        val group = WidgetGroup()

        group.addActor(ActorModel(ActorModel.Companion.ActorTypes.BUTTON_TYPE, path, path,
                boundX = 200F, boundY = 200F, listener = listeners.buyClickUpgrade(this)).getActorFromModel())

        group.addActor(ActorModel(ActorModel.Companion.ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.click_income_invisible_texture,
                Constants.paths.click_income_invisible_texture, buttonText = name,
                boundX = 100F, boundY = 100F, positionX = 200F).getActorFromModel())

        amountActor = ActorModel(ActorModel.Companion.ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.click_income_invisible_texture,
                Constants.paths.click_income_invisible_texture, buttonText = amount.toString(),
                boundX = 100F, boundY = 100F, positionX = 200F, positionY = 100F).getActorFromModel()
        group.addActor(amountActor)

        priceActor = ActorModel(ActorModel.Companion.ActorTypes.TEXT_BUTTON_TYPE, Constants.paths.click_income_invisible_texture,
                Constants.paths.click_income_invisible_texture, buttonText = price.toString(),
                boundX = 100F, boundY = 100F, positionX = 300F, positionY = 100F).getActorFromModel()
        group.addActor(priceActor)

        return group
    }

    fun incrementAmount(): String {
        amount = (amount.add(BigInteger.ONE))
        return amount.toString()
    }

    fun incrementPrice(): String {
        getPriceAfterUpgrading(price)
        return price.toString()
    }

    private fun getPrice(id: Int, amount: Long): String {
        var amountTMP = amount
        var idTMP = id + 1.0
        var price = Math.pow(10.0, idTMP)
        while (amountTMP-- > 0) {
            price += price + price/100
        }
        return price.toLong().toString()
    }

    private fun getPriceAfterUpgrading(price: BigInteger){
        val priceTMP = BigInteger(price.toString())
        price.add(priceTMP)
    }
}