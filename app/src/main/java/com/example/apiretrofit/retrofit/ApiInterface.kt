package com.example.apiretrofit.retrofit

import com.example.apiretrofit.models.SchoolClass
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/class")
    fun getClasses() : Call<List<SchoolClass>>

}