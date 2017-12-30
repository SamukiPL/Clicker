package me.samuki.clicker.base.androidcommunication

import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.base.interfaces.communication.SaveListener


class SaveListenerImpl : SaveListener {

    override fun saveEverything() {
        saveAmount()
    }

    private fun saveAmount() {
        val amount: String = IncomeHandlerImpl.getInstance().getAmountBigInteger().toString()
        SharedPrefs.getInstance().saveAmount(amount)
    }
}