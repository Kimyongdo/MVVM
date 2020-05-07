package com.example.simplifiedcoding_youtube_mvvm.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//모든 함수마다 suspend를 붙일 수 없으니 코루틴 클래스를 따로 만들어서 사용
object Coroutine {

    fun main(work:suspend(()->Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()//????
        }//코루틴 함수들
}