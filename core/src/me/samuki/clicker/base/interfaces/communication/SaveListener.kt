package me.samuki.clicker.base.interfaces.communication


interface SaveListener {
    fun saveEverything()
    fun saveLastTime(lastTime: Long)
}