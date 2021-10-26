package com.example.apiretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiretrofit.models.*
import com.example.apiretrofit.resource.Resource
import com.example.apiretrofit.retrofit.ApiInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

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
                },{it->
                    getLogins.value = Resource.error(it.localizedMessage)
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
                    getProductCategory.value = Resource.success(response.payload)
                },{it->
                    getProductCategory.value = Resource.error(it.localizedMessage)
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
                    getProduct.value = Resource.success(response.payload)
                },{it->
                    getProduct.value = Resource.error(it.localizedMessage)
                })
        )
    }
}