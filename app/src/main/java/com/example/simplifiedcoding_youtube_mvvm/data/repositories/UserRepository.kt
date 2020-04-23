package com.example.simplifiedcoding_youtube_mvvm.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplifiedcoding_youtube_mvvm.data.network.Myapi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun userLogin(email:String, password:String):LiveData<String>{//LiveData는 interface이므로
        val loginResponse = MutableLiveData<String>() //LiveData를 상속받은 MutableLiveData을 사용함.
        Myapi().userLogin(email, password)
            .enqueue(object :Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {//오류났을 경우
                    loginResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful){ //성공했을 경우
                        loginResponse.value = response.body()?.string()
                    }else{
                        loginResponse.value = response.errorBody()?.string()

                    }
                }

            })//retrofir2 callback이여야함
        return loginResponse
    }
}