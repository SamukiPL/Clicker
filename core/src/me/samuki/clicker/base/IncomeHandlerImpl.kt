package me.samuki.clicker.base

import me.samuki.clicker.base.interfaces.BaseSingleton
import me.samuki.clicker.base.interfaces.IncomeHandler
import me.samuki.clicker.base.interfaces.communication.AmountTextRefresher
import me.samuki.clicker.models.UpgradeModel
import java.math.BigInteger
import java.util.*


class IncomeHandlerImpl private constructor() : IncomeHandler {
    companion object : BaseSingleton<IncomeHandler> {
        private val INSTANCE: IncomeHandler = IncomeHandlerImpl()

        override fun getInstance(): IncomeHandler {
            return INSTANCE
        }
    }

    lateinit var clicksAmount: BigInteger
    lateinit var amount: BigInteger
    lateinit var income: BigInteger
    private var amountTextRefresher: AmountTextRefresher? = null

    init {
        initClickAmount()
        initAmount()
        initIncome()
        initUpgrades()
        handleIncomeLoop()
    }

    private fun initClickAmount() {
        clicksAmount = BigInteger(SharedPrefs.getInstance().prefs.getString(Constants.prefs.click_amount, "0"))
    }

    private fun initAmount() {
        amount = BigInteger(SharedPrefs.getInstance().prefs.getString(Constants.prefs.amount, "0"))
    }

    private fun initIncome() {
        income = BigInteger(SharedPrefs.getInstance().prefs.getString(Constants.prefs.income, "0"))
    }

    private fun initUpgrades() {

    }

    override fun getAmountString(): String {
        return BasicMethods.shortenNumber(amount.toString())
    }

    override fun getIncomeString(): String {
        return income.toString()
    }

    override fun getAmountBigInteger(): BigInteger {
        return amount
    }

    override fun addClickIncome() {
        amount += ClickUpgradesHandlerImpl.getInstance().clickIncome
    }

    override fun addToIncome(incomeToAdd: String) {
        income += BigInteger(incomeToAdd)
    }

    override fun subtractPriceFromAmount(price: String) {
        amount -= BigInteger(BasicMethods.addZerosToString(price))
    }

    override fun incrementClicksAmount() {
        clicksAmount.add(BigInteger.ONE)
    }

    override fun setAmountTextRefresher(amountTextRefresher: AmountTextRefresher?) {
        this.amountTextRefresher = amountTextRefresher
    }

    override fun doubleTheAmount() {
        amount += amount
    }

    override fun gatherBackgroundIncome(seconds: String) {
        amount += (income * BigInteger(seconds))
    }

    private fun handleIncomeLoop() {
        Timer().scheduleAtFixedRate(object: TimerTask() {
                    override fun run() {
                        amount += income
                        amountTextRefresher?.refreshAmount(getAmountString())
                    }

                }, 1000L, 1000L)
    }
}