package com.example.simplifiedcoding_youtube_mvvm.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplifiedcoding_youtube_mvvm.data.network.Myapi
import com.example.simplifiedcoding_youtube_mvvm.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//retrofit 그릇과 연결할 재료들을 넣는 곳
class UserRepository {
    suspend fun userLogin(email:String, password:String) : Response<AuthResponse>{ //LiveData = abstract이므로
        return Myapi().userLogin(email,password)//코루틴 이용시 이를 호출하는 함수도 suspend 붙여야함


//        chpater 5까지 쓰다가 6에서 지움
//        val loginResponse = MutableLiveData<String>() //LiveData -> MutableLiveData로 객체생성
//        Myapi().userLogin(email,password)
//            .enqueue(object :Callback<ResponseBody>{//enqueue = asyncronous
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    loginResponse.value = t.message
//                    print("onFailure"+ loginResponse.value.toString())
//                }
//
//                override fun onResponse(
//                    call: Call<ResponseBody>,
//                    response: Response<ResponseBody>
//                ) {
//                    if(response.isSuccessful){
//                        loginResponse.value = response.body()?.toString()//잘 도착
//                        Log.d("isSuccessful",loginResponse.value.toString())
//                    }else{
//                        loginResponse.value = response.errorBody()?.toString() //오긴 왔는데 에러
//                        Log.d("errorBody ",loginResponse.value.toString())
//                    }
//                }//ResponseBody는 인터페이스 Myapi의 Call->Callback <ResponseBody>와 동일
//            })
//        return loginResponse

    }
}