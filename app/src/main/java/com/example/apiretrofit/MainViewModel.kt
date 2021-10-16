package com.example.apiretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiretrofit.models.LoginResponse
import com.example.apiretrofit.models.User
import com.example.apiretrofit.resource.Resource
import com.example.apiretrofit.resource.ResourceState
import com.google.rpc.context.AttributeContext

class MainViewModel(private val networkHelper: NetworkHelper) : ViewModel() {
    val getLogins: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    fun getLogin(user: User) {
        getLogins.value = Resource.loading()
        networkHelper.getUsers(
            onSuccess = {
                getLogins.value = Resource.success(it)
            },
            onFailureListener = {
                getLogins.value = Resource.error(it)
            }, user)
    }
}