package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.simplifiedcoding_youtube_mvvm.data.repositories.UserRepository

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
        //나중에 injection을 배우겠지만 mvvm패턴에서 이렇게 사용하는 방식은 안좋은방식
        //AuthViewModel안에 UserRepository()객체로 연결되어 있어서 tight coupling이 이루어짐.
        val loginResponse = UserRepository().userLogin(email!!,password!!)//MutableLiveData 리턴
        authListener?.onSuccess(loginResponse)
    }


}