package me.samuki.clicker

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import me.samuki.clicker.interfaces.IGameServicesHelper


class GameServicesHelper(val context: Context) : IGameServicesHelper {
    companion object {
        val RC_UNUSED = 5001
        val RC_SIGN_IN = 9001
    }

    var signInClient: GoogleSignInClient = GoogleSignIn.getClient(context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).build())

    override fun isSignedIn(): Boolean {
        return GoogleSignIn.getLastSignedInAccount(context) != null
    }

    override fun signIn() {
        TODO("Łukasz weź się do roboty!")
    }

    override fun silentSignIn() {
        signInClient.silentSignIn().addOnCompleteListener(context as Activity, silentSignInListener())
    }

    override fun singOut() {
        if (isSignedIn()) {
            signInClient.signOut().addOnCompleteListener(signOutListener())
        }
    }

    override fun onResult(requestCode: Int, intent: Intent) {
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(intent)

            try {
                val account: GoogleSignInAccount = task.getResult(ApiException::class.java)

            } catch (e: ApiException) {

            }
        }
    }

    private fun startSignInIntent() {
        (context as Activity).startActivityForResult(signInClient.signInIntent, RC_SIGN_IN)
    }

    private fun silentSignInListener(): OnCompleteListener<GoogleSignInAccount> {
        return OnCompleteListener { task ->
            if (task.isSuccessful) {

            }
            else {

            }
        }
    }

    private fun signOutListener(): OnCompleteListener<Void> {
        return OnCompleteListener { task ->
            if (task.isSuccessful) {

            }
        }
    }
}