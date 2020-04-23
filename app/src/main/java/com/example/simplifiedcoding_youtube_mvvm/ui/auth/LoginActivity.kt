package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simplifiedcoding_youtube_mvvm.R
import com.example.simplifiedcoding_youtube_mvvm.databinding.ActivityLoginBinding
import com.example.simplifiedcoding_youtube_mvvm.util.Toast


//MainActivity -> LoginActivity로 name변경, xml도 login.xml로 변경 
class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //이 화면의 setContentView는 지우고,
        //setContentView(R.layout.activity_login)
        //ActivityLoginBinding의 이름은 layout의 activity_login.xml을 기준으로 자동으로 생성됨.
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)//xml과
        val viewModel =ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel //묶어준다.
        viewModel.authListener= this //this는 이 클래스의 AuthListener 요소들을 묶어주는 셈
    }

    override fun onStarted() {
        Toast("Login Started")
    }

    override fun onSuccess() {
        Toast("Login onSuccess")
    }

    override fun onFailure(message: String) {
        Toast(message)
    }
}
