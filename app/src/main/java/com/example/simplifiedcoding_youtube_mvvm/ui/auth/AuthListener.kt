package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import androidx.lifecycle.LiveData
import com.example.simplifiedcoding_youtube_mvvm.data.db.entities.User

//LoginActivity에 implement할 것을 만듦
interface AuthListener {
    fun onStarted()//프로그래스바 진행
    fun onSuccess(user:User)//성공시
//    fun onSuccess(loginResponse: LiveData<String>)//성공시-chpater5까지
    fun onFailure(message:String)//실패시
}