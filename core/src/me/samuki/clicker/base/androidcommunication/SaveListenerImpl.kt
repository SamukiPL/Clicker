package me.samuki.clicker.base.androidcommunication

import me.samuki.clicker.base.Constants
import me.samuki.clicker.base.IncomeHandlerImpl
import me.samuki.clicker.base.SharedPrefs
import me.samuki.clicker.base.interfaces.communication.SaveListener


class SaveListenerImpl : SaveListener {

    override fun saveEverything() {
        saveAmount()
        saveIncome()
    }

    override fun saveLastTime(lastTime: Long) {
        SharedPrefs.getInstance().prefs.putLong(Constants.prefs.last_time, lastTime)
        SharedPrefs.getInstance().flush()
    }

    private fun saveAmount() {
        val amount: String = IncomeHandlerImpl.getInstance().getAmountBigInteger().toString()
        SharedPrefs.getInstance().saveAmount(amount)
    }

    private fun saveIncome() {
        val income: String = IncomeHandlerImpl.getInstance().getIncomeString()
        SharedPrefs.getInstance().saveIncome(income)
    }
}