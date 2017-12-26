package me.samuki.clicker.base

import me.samuki.clicker.base.interfaces.ClickUpgradesHandler
import me.samuki.clicker.base.interfaces.IncomeHandler
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
        when (id) {
            0 -> tromboneUpdate(amount)
            1 -> trumpetUpdate(amount)
            2 -> flugelhornUpdate(amount)
            3 -> tubaUpdate(amount)
        }
        saveActualClickIncome()
    }

    private fun tromboneUpdate(amount: Long) {
        clickIncome += BigInteger.ONE
    }

    private fun trumpetUpdate(amount: Long) {
        clickIncome += BigInteger.valueOf(10L)
    }

    private fun flugelhornUpdate(amount: Long) {
        clickIncome += BigInteger.valueOf(100L)
    }

    private fun tubaUpdate(amount: Long) {
        clickIncome += BigInteger.valueOf(1000L)
    }
}