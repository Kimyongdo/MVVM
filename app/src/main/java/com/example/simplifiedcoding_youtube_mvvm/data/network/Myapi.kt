package com.example.simplifiedcoding_youtube_mvvm.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//retrofit을 연결하는 담는 '그릇'임.
interface Myapi {

    @FormUrlEncoded//POST 사용시 필수
    @POST("login")
    fun userLogin(
        @Field("email") email:String, //@Field의 이름은 POSTMAN(API)와 동일하게, 변수이름은 자유롭게.
        @Field("password") password:String
    ):Call<ResponseBody>//ResponseBody를 달라.

    companion object{//가장 먼저 출력
        operator fun invoke():Myapi{ //invoke으로 실행
            return Retrofit.Builder() //return으로 출력
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Myapi::class.java)//여기로 return
        }
    }
}

