package com.example.simplifiedcoding_youtube_mvvm.data.network

import com.example.simplifiedcoding_youtube_mvvm.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//retrofit을 연결하는 담는 '그릇'임.
interface Myapi {

    @FormUrlEncoded//POST 사용시 필수
    @POST("login")
    suspend fun userLogin(//suspend 뭐지?? - 코루틴에서 suspend가 중심
        @Field("email") email:String, //@Field의 이름은 POSTMAN(API)와 동일하게, 변수이름은 자유롭게.
        @Field("password") password:String
    ):Response<AuthResponse>//ResponseBody를 달라. ResponseBody를->AuthResponse로 변경

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

