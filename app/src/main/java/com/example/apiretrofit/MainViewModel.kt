package com.example.apiretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiretrofit.models.*
import com.example.apiretrofit.resource.Resource

class MainViewModel(private val networkHelper: NetworkHelper) : ViewModel() {
    val getLogins: MutableLiveData<Resource<GenericResponse<LoginResponse>>> = MutableLiveData()
    val getProductCategory: MutableLiveData<Resource<List<ProductCategory>>> = MutableLiveData()
    val getProduct : MutableLiveData<Resource<List<Product>>> = MutableLiveData()
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
    fun getProductCategories(){
        getProductCategory.value = Resource.loading()
        networkHelper.getProCategories({
            getProductCategory.value = Resource.success(it)
        },{
            getProductCategory.value = Resource.error(it)
        })
    }
    fun getProduct(id : Int){
        getProduct.value = Resource.loading()
        networkHelper.getProduct(id,{
            getProduct.value = Resource.success(it)
        }, {
            getProduct.value = Resource.error(it)
        })
    }
}