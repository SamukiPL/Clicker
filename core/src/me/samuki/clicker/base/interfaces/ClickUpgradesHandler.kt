package me.samuki.clicker.base.interfaces

import java.math.BigInteger


interface ClickUpgradesHandler {
    var clickIncome: BigInteger
    fun handleClickUpgrade(id: Int, amount: Long)
}