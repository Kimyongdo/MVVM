package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

//ViewModel을 상속받음.
class AuthViewModel : ViewModel() {
    var email :String? = null
    var password : String? = null

    //button으로 만들고 싶다면 view:View는 중요.
    fun onLoginButtonClick(view:View){
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            //
            return
        }
        //success
    }

}