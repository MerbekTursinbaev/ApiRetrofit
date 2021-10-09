package com.example.apiretrofit.retrofit

import com.example.apiretrofit.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/api/client/login")
    fun getUsers(@Body user : User) : Call<List<User>>
}