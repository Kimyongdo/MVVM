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

//xml에 있는 progressbar의 효과를 메소드에서 추가했기 때문에 사용할 수 있다.
fun ProgressBar.show(){ //기본 Progressbar함수에서 show()함수 추가하기(없는 것을 추가)
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){ //기본 Progressbar함수에서 hide()함수 추가하기(없는 것을 추가)
    visibility = View.VISIBLE
}