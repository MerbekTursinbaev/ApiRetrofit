package com.example.apiretrofit.retrofit
import com.example.apiretrofit.models.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*

interface ApiInterface {
    @POST("/api/client/login")
    fun getUsers(@Body user : User) : io.reactivex.rxjava3.core.Observable<GenericResponse<LoginResponse>>

    @GET("/api/categories")
    fun getProductCategories() : io.reactivex.rxjava3.core.Observable<GenericResponse<List<ProductCategory>>>

    @GET ("api/categories/{category_id}")
    fun getProductsCategoryById(@Path("category_id") id : Int) : io.reactivex.rxjava3.core.Observable<GenericResponse<List<Product>>>

}