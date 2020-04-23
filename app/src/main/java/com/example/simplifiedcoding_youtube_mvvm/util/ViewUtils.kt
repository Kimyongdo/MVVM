package com.example.simplifiedcoding_youtube_mvvm.util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

//길게 Toast.makeText(this,message,Toast.LENGTH_LONG).show()로 쓰지 않아도 미리 준비해준다면
//Toast(String)으로 설정해도 가능함. (편리기능일뿐)
fun Context.Toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}


//프로그래스바 함수에 직접 .show()를 추가한 상황
//progressbar는 이제 show()메소드를 가지게 됨.
fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.GONE
}