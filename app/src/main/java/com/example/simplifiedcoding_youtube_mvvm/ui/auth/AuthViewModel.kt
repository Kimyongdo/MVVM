package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

//viewModel 상속받음
class AuthViewModel : ViewModel(){

    var email : String?  = null
    var password : String?  = null

    var authListener : AuthListener?=null


    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invaild email or password")
            return
        }
        //success
        authListener?.onSuccess()
    }
}