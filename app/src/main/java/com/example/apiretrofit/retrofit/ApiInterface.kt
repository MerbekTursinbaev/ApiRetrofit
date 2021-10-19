package com.example.apiretrofit.retrofit

import com.example.apiretrofit.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @POST("/api/client/login")
    fun getUsers(@Body user : User) : Call<GenericResponse<LoginResponse>>

    @GET ("/api/categories")
    fun getProductCategories() : Call<GenericResponse<List<ProductCategory>>>

    @GET ("api/categories/{category_id}")
    fun getProductsCategoryById(@Path ("category_id") id : Int) :Call<GenericResponse<List<Product>>>
}