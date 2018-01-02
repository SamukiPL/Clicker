package me.samuki.clicker.base

import me.samuki.clicker.base.interfaces.ClickUpgradesHandler
import me.samuki.clicker.base.interfaces.IncomeHandler
import sun.security.provider.SHA
import java.math.BigInteger


class ClickUpgradesHandlerImpl : ClickUpgradesHandler {
    companion object {
        private val INSTANCE: ClickUpgradesHandler = ClickUpgradesHandlerImpl()

        fun getInstance(): ClickUpgradesHandler = INSTANCE
    }

    private constructor()

    init {
        initClickIncome()
    }

    override lateinit var clickIncome: BigInteger


    private fun initClickIncome() {
        clickIncome = BigInteger(SharedPrefs.getInstance().prefs.getString(Constants.prefs.click_income, "1"))

    }

    private fun saveActualClickIncome() {
        SharedPrefs.getInstance().prefs.putString(Constants.prefs.click_income, clickIncome.toString())
        SharedPrefs.getInstance().flush()
    }

    override fun handleClickUpgrade(id: Int, amount: Long) {
        val lastIncomeString = SharedPrefs.getInstance().prefs.getString(
                Constants.prefs.click_upgrades_income.replace(Constants.replace_mark, id.toString()),
                Constants.upgrades_info[id].clickIncome)
        var lastIncome = BigInteger(lastIncomeString)
        if (amount > 0) {
            var addToIncome = BigInteger(lastIncomeString)
            addToIncome /= BigInteger.valueOf((Constants.numbers.click_upgrade_divider - (id + 1)).toLong())
            addToIncome += BigInteger.ONE
            lastIncome += addToIncome
            println(lastIncome.toString())
            SharedPrefs.getInstance().prefs.putString(
                    Constants.prefs.click_upgrades_income.replace(Constants.replace_mark, id.toString()),
                    lastIncome.toString())
            SharedPrefs.getInstance().flush()
        }
        clickIncome += lastIncome
        saveActualClickIncome()
    }
}