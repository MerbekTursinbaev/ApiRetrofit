package com.example.apiretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiretrofit.models.*
import com.example.apiretrofit.resource.Resource
import com.example.apiretrofit.retrofit.ApiInterface

class MainViewModel(private val api: ApiInterface) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val getLogins: MutableLiveData<Resource<GenericResponse<LoginResponse>>> = MutableLiveData()
    val getProductCategory: MutableLiveData<Resource<List<ProductCategory>>> = MutableLiveData()
    val getProduct : MutableLiveData<Resource<List<Product>>> = MutableLiveData()
    fun getLogin(user: User) {
        getLogins.value = Resource.loading()
        compositeDisposable.add(
            api.getUsers(user)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    getLogins.value = Resource.success(response)
                },{
                    getLogins.value = Resource.error(error.localizedMessage)
                })
        )
    }
    fun getProductCategories(){
        getProductCategory.value = Resource.loading()
        compositeDisposable.add(
            api.getProductCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    getProductCategory.value = Resource.success(response)
                },{
                    getProductCategory.value = Resource.error(error.localizedMessage)
                })
        )
    }
    fun getProduct(id : Int){
        getProduct.value = Resource.loading()
        compositeDisposable.add(
            api.getProductsCategoryById(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    getProduct.value = Resource.success(response)
                },{
                    getProduct.value = Resource.error(error.localizedMessage)
                })
        )
    }
}