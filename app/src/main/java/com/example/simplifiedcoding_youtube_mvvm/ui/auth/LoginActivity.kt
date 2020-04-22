package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplifiedcoding_youtube_mvvm.R


//MainActivity -> LoginActivity로 name변경, xml도 login.xml로 변경 
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
