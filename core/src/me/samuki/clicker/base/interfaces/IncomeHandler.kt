package me.samuki.clicker.base.interfaces

import me.samuki.clicker.base.interfaces.communication.AmountTextRefresher
import java.math.BigInteger

interface IncomeHandler {
    fun getAmountString(): String
    fun getAmountBigInteger(): BigInteger
    fun addClickIncome()
    fun subtractPriceFromAmount(price: String)
    fun incrementClicksAmount()
    fun setAmountTextRefresher(amountTextRefresher: AmountTextRefresher?)
}