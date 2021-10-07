package com.example.apiretrofit

import com.example.apiretrofit.models.SchoolClass
import com.example.apiretrofit.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val apiClient: Retrofit) {
    fun getClasses(listener: NetworkListener){
        val call = apiClient.create(ApiInterface::class.java).getClasses()
        call.enqueue(object : Callback<List<SchoolClass>>{
            override fun onResponse(
                call: Call<List<SchoolClass>>?,
                response: Response<List<SchoolClass>>?
            ) {
                listener.onSchoolClassesResponse(response?.body())
            }
            override fun onFailure(call: Call<List<SchoolClass>>?, t: Throwable?) {
                listener.onSchoolClassesFailure(t?.localizedMessage)
            }
        })
    }
}