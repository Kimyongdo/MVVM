package com.example.simplifiedcoding_youtube_mvvm.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


//postman의
//{
//    "isSuccessful": true,
//    "message": "Login Successful",
//    "user": {
//    "id": 1,
//    "name": "Belal Khan",
//    "email": "probelalkhan@gmail.com",
//    "email_verified_at": null,
//    "created_at": "2020-03-02 06:27:15",
//    "updated_at": "2020-03-02 06:27:15"
//}
////} 값을 그대로 여기다가 넣는다.

const val CURRENT_USER_ID = 0

@Entity //room 라이브러리 @Entity는 '테이블'임
data class User (
    var id:Int?=null,
    var name:String?=null,
    var email:String?=null,
    var password:String?=null,
    var created_at:String?=null,
    var updated_at:String?=null
){
    //room 라이브러리, 휴대폰 내부에 DataBase만드는 중
    @PrimaryKey(autoGenerate = false)//false로 만들어서 새로 만들지 않고 계속 하나만 덮어씌워지도록 설정 )현 유저는 나혼자)
    var uid:Int =CURRENT_USER_ID
}