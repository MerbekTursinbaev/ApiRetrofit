package com.example.apiretrofit.retrofit

import android.database.Observable
import com.example.apiretrofit.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @POST("/api/client/login")
    fun getUsers(@Body user : User) : Observable<GenericResponse<LoginResponse>>

    @GET ("/api/categories")
    fun getProductCategories() : Observable<GenericResponse<List<ProductCategory>>>

    @GET ("api/categories/{category_id}")
    fun getProductsCategoryById(@Path ("category_id") id : Int) : Observable<GenericResponse<List<Product>>>
}