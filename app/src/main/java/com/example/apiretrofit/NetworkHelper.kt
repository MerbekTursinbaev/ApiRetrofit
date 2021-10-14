package com.example.apiretrofit

import com.example.apiretrofit.models.LoginResponse
import com.example.apiretrofit.models.User
import com.example.apiretrofit.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val apiClient: Retrofit) {
    fun getUsers(listener: NetworkListener, user : User){
        val call = apiClient.create(ApiInterface::class.java).getUsers(user)
        call.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(
                call: Call<LoginResponse>?,
                response: Response<LoginResponse>?
            ) {
                listener.onUsersResponse(response!!.body())
            }
            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                listener.onUsersFailure(t?.localizedMessage)
            }
        })
    }
}