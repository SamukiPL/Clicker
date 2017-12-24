package me.samuki.clicker.base.interfaces

import java.math.BigInteger

interface IncomeHandler {
    fun getAmountString(): String
    fun addClickIncome()
    fun refreshUpgrade(index: Int, amount: Int)
}