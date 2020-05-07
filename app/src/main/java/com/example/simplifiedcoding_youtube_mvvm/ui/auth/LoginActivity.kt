package com.example.simplifiedcoding_youtube_mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.simplifiedcoding_youtube_mvvm.R
import com.example.simplifiedcoding_youtube_mvvm.data.db.entities.User
import com.example.simplifiedcoding_youtube_mvvm.databinding.ActivityLoginBinding
import com.example.simplifiedcoding_youtube_mvvm.util.Toast
import com.example.simplifiedcoding_youtube_mvvm.util.hide
import com.example.simplifiedcoding_youtube_mvvm.util.show
import kotlinx.android.synthetic.main.activity_login.*

//https://api.simplifiedcoding.in/course-apis/mvvm/login
//probelalkhan@gmail.com
//123456

//MainActivity -> LoginActivity로 name변경, xml도 login.xml로 변경
class LoginActivity : AppCompatActivity(), AuthListener { //AuthListener을 implement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login) //기존 setContentView 제거

        // val binding:ActivityLoginBinding -> ActivityLoginBinding의 이름은 layout의 activity_login.xml을 기준으로 자동으로 생성됨.
        val binding:ActivityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login)//새로운 setContentView
        val viewModel =ViewModelProviders.of(this).get(AuthViewModel::class.java)//VM을 연결
        binding.viewmodel = viewModel //묶어준다.
        viewModel.authListener= this //viewModel.authListener == AuthViewModel.class의 authListener, this는 AuthListener implementation
    }

    //interfcae AuthListener -> override
    override fun onStarted() {
        //Toast("Login Started")//ViewUtils.kt에서 줄여줌
        progress_bar.show()//show()는 원래 있는게 아니라, util에서 따로 만들어 준것 (이렇게 까지 해야하나 싶은데)
    }


    override fun onSuccess(user: User) {
        Toast("${user.name} is Logged in ")
    }

    //chpater6까지
//    override fun onSuccess(loginResponse: LiveData<String>) {//알트엔터로 자동으로 추가됨.
//        //Toast("Login onSuccess")
//        loginResponse.observe(this, Observer {
//            Toast("onscuees : $it")//
//            progress_bar.hide()//hide()따로 만들어 준것. import해야함.
//        })
//
//    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        Toast("실패 : $message")
    }
}
