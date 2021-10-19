package com.example.apiretrofit

import com.example.apiretrofit.models.*
import com.example.apiretrofit.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val apiClient: Retrofit) {
    fun getUsers(onSuccess: (genericResponse: GenericResponse<LoginResponse>) -> Unit, onFailureListener: (message: String?) -> Unit, user: User){
        val call = apiClient.create(ApiInterface::class.java).getUsers(user)
        call.enqueue(object : Callback<GenericResponse<LoginResponse>>{
            override fun onResponse(
                call: Call<GenericResponse<LoginResponse>>?,
                response: Response<GenericResponse<LoginResponse>>?
            ) {
                response?.let{
                    onSuccess.invoke(response.body())
                }

            }
            override fun onFailure(call: Call<GenericResponse<LoginResponse>>?, t: Throwable?) {
                t?.let {
                    onFailureListener.invoke(it.localizedMessage)
                }
            }
        })
    }
    fun getProCategories(onSuccess: (product: List<ProductCategory>) -> Unit, onFailureListener: (message: String?) -> Unit){
        val call = apiClient.create(ApiInterface::class.java).getProductCategories()
        call.enqueue(object : Callback<GenericResponse<List<ProductCategory>>>{
            override fun onResponse(
                call: Call<GenericResponse<List<ProductCategory>>>?,
                response: Response<GenericResponse<List<ProductCategory>>>?
            ) {
                response.let {
                    onSuccess.invoke(response?.body()!!.payload)
                }
            }
            override fun onFailure(
                call: Call<GenericResponse<List<ProductCategory>>>?,
                t: Throwable?
            ) {
                onFailureListener.invoke(t?.localizedMessage)
            }
        }
        )
    }
    fun getProduct(id: Int, onSuccess:(category:List<Product>)->Unit, onFailureListener: (message: String?) -> Unit){
        val call = apiClient.create(ApiInterface::class.java).getProductsCategoryById(id)
        call.enqueue(object : Callback<GenericResponse<List<Product>>>{
            override fun onResponse(
                call: Call<GenericResponse<List<Product>>>?,
                response: Response<GenericResponse<List<Product>>>?
            ) {
                onSuccess.invoke(response?.body()!!.payload)
            }
            override fun onFailure(call: Call<GenericResponse<List<Product>>>?, t: Throwable?) {
                onFailureListener.invoke(t?.localizedMessage)
            }
        })
    }
}