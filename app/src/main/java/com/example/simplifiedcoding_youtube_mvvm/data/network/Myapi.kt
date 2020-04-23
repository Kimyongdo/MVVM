package com.example.simplifiedcoding_youtube_mvvm.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Myapi {

    @FormUrlEncoded //반드시 써주어야 연결됨
    @POST("login") //post방식으로 /login에 해당하는 값
    fun userLogin(
        @Field("email") email:String, //@Field("email")는 postman의 key에 들어갈 이름과 동일하게 사용
        @Field("password") password:String
    ):Call<ResponseBody> //response의 body값을 준다.  {   } 해당하는 값

    companion object{
        operator fun invoke() : Myapi{
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Myapi::class.java)
        }
    }
}