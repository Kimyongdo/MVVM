package com.example.simplifiedcoding_youtube_mvvm.util

import android.content.Context
import android.widget.Toast

//길게 Toast.makeText(this,message,Toast.LENGTH_LONG).show()로 쓰지 않아도 미리 준비해준다면
//Toast(String)으로 설정해도 가능함. (편리기능일뿐)
fun Context.Toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}