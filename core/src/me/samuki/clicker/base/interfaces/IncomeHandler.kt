package me.samuki.clicker.base.interfaces

import java.math.BigInteger

interface IncomeHandler {
    fun getAmountString(): String
    fun addClickIncome(clickIncome: BigInteger)
    fun refreshUpgrade(index: Int, amount: Int)
}