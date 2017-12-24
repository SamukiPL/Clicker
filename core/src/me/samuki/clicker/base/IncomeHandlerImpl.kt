package me.samuki.clicker.base

import com.badlogic.gdx.Gdx
import me.samuki.clicker.base.enums.ModelTypes
import me.samuki.clicker.base.interfaces.BaseSingleton
import me.samuki.clicker.base.interfaces.IncomeHandler
import me.samuki.clicker.models.UpgradeModel
import java.lang.Thread.sleep
import java.math.BigInteger
import java.util.*


class IncomeHandlerImpl private constructor() : IncomeHandler {
    companion object : BaseSingleton<IncomeHandler> {
        private val INSTANCE: IncomeHandler = IncomeHandlerImpl()

        override fun getInstance(): IncomeHandler {
            return INSTANCE
        }
    }

    lateinit var upgrades: List<UpgradeModel>
    lateinit var amount: BigInteger
    lateinit var income: BigInteger
    lateinit var clickIncome: BigInteger

    init {
        initAmount()
        initIncome()
        initClickIncome()
        initUpgrades()
        handleIncomeLoop()
    }

    private fun initAmount() {
        amount = BigInteger(SharedPrefs.getInstance().prefs.getString(Constants.prefs.amount, "0"))
    }

    private fun initIncome() {
        income = BigInteger(SharedPrefs.getInstance().prefs.getString(Constants.prefs.income, "0"))
    }

    private fun initClickIncome() {
        clickIncome = BigInteger(SharedPrefs.getInstance().prefs.getString(Constants.prefs.click_income, "1"))
    }

    private fun initUpgrades() {
        upgrades = ArrayList()
        var x: Int = 0
        Constants.upgrades_info.forEach {
            upgrade -> run {
                val path: String = Constants.paths.base_upgrade_texture_path
                        .replace(Constants.replace_mark, x.toString())
                val prefsName: String = Constants.prefs.upgrades_bought
                        .replace(Constants.replace_mark, x.toString())
                upgrades.toMutableList().add(UpgradeModel(ModelTypes.UPGRADE_MODEL, x, upgrade.name,
                        SharedPrefs.getInstance().prefs.getInteger(prefsName, 0), upgrade.income, path))
                x++
            }
        }
    }

    override fun getAmountString(): String {
        return amount.toString()
    }

    override fun refreshUpgrade(index: Int, amount: Int) {
        upgrades[index].amount = amount
        SharedPrefs.getInstance().prefs.putInteger(Constants.prefs.upgrades_bought
                .replace(Constants.replace_mark, index.toString()), amount)
    }

    override fun addClickIncome() {
        amount += clickIncome
    }

    private fun handleIncomeLoop() {
        Timer().scheduleAtFixedRate(object: TimerTask() {
                    override fun run() {
                        amount += income
                        System.out.println(amount.toString())
                    }

                }, 1000L, 1000L)
    }
}