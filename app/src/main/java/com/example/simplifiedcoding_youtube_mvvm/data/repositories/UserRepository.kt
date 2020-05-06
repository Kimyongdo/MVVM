package com.example.simplifiedcoding_youtube_mvvm.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplifiedcoding_youtube_mvvm.data.network.Myapi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//retrofit 그릇과 연결할 재료들을 넣는 곳
class UserRepository {
    fun userLogin(email:String, password:String) : LiveData<String>{ //LiveData = abstract이므로
        val loginResponse = MutableLiveData<String>() //LiveData -> MutableLiveData로 객체생성

        Myapi().userLogin(email,password)
            .enqueue(object :Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful){
                        loginResponse.value = response.body()?.toString()//잘 도착
                    }else{
                        loginResponse.value = response.errorBody()?.toString() //오긴 왔는데 에러
                    }
                }//ResponseBody는 인터페이스 Myapi의 Call->Callback <ResponseBody>와 동일
            })
        return loginResponse

    }
}