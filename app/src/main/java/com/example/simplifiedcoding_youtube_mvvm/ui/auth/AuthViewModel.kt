package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.simplifiedcoding_youtube_mvvm.data.repositories.UserRepository

//viewModel 상속받음(라이브러리)
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

        //injection을 배우겠지만 한 클래스 안에 다른 클래스를 연결하는건 좋은 방법이 아님.
        //AuthViewModel이 UserRepository을 의존하기 때문임.
        val loginResponse = UserRepository().userLogin(email!!,password!!)
        authListener?.onSuccess(loginResponse)//알트엔터를 눌러 interface에 매개변수 추가하기.
    }
}