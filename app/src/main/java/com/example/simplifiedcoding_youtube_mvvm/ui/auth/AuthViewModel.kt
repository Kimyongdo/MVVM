package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.simplifiedcoding_youtube_mvvm.data.repositories.UserRepository
import com.example.simplifiedcoding_youtube_mvvm.util.Coroutine

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

        //코루틴 scope
        Coroutine.main {
            val response = UserRepository().userLogin(email!!,password!!)
            if(response.isSuccessful){
                authListener?.onSuccess(response.body()?.user!!)
            }else{
                authListener?.onFailure("Error code : ${response.code()}")
            }
        }


        //chapter 6에서 지움
        //injection을 배우겠지만 한 클래스 안에 다른 클래스를 연결하는건 좋은 방법이 아님.
        //AuthViewModel이 UserRepository을 의존하기 때문임.
        //val loginResponse = UserRepository().userLogin(email!!,password!!)
        //authListener?.onSuccess(loginResponse)//알트엔터를 눌러 interface에 매개변수 추가하기.
    }
}