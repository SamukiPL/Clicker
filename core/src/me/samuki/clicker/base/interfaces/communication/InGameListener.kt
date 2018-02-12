package me.samuki.clicker.base.interfaces.communication


interface InGameListener {
    fun playerWasRewarded()
    fun adIsReady(ready: Boolean)
}