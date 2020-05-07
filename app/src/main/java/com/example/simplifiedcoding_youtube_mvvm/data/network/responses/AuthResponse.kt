package com.example.simplifiedcoding_youtube_mvvm.data.network.responses

import com.example.simplifiedcoding_youtube_mvvm.data.db.entities.User

//postman의 json볼 수 있는 값을 저장하기
data class AuthResponse(
     val isSucssful : Boolean?,
     val message : String?,
     val user : User? //User 클래스 another json으로 담겨져있기 때문임
)