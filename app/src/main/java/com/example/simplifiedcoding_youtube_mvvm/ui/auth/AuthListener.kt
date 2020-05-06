package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import androidx.lifecycle.LiveData

//LoginActivity에 implement할 것을 만듦
interface AuthListener {
    fun onStarted()//프로그래스바 진행
    fun onSuccess(loginResponse: LiveData<String>)//성공시
    fun onFailure(message:String)//실패시
}