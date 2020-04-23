package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplifiedcoding_youtube_mvvm.R


//MainActivity -> LoginActivity로 name변경, xml도 login.xml로 변경 
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //전통적인 방법 - EditText를 가져오지만 MVVM패턴에서는 다르게 설정
    }
}
