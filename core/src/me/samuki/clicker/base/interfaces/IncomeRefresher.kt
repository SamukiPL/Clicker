package me.samuki.clicker.base.interfaces


interface IncomeRefresher {
    fun getAmount()
    fun refreshUpgrade(index: Int, amount: Int)
}