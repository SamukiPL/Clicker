package me.samuki.clicker.base.interfaces

import java.math.BigInteger

interface IncomeHandler {
    fun getAmountString(): String
    fun getAmountBigInteger(): BigInteger
    fun addClickIncome()
    fun subtractPriceFromAmount(price: BigInteger)
    fun incrementClicksAmount()
}