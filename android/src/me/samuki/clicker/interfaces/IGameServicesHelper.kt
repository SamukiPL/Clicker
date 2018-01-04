package me.samuki.clicker.interfaces

import android.content.Intent


interface IGameServicesHelper {
    fun isSignedIn(): Boolean
    fun signIn()
    fun silentSignIn()
    fun singOut()
    fun onResult(requestCode: Int, intent: Intent)
}