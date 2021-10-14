package com.example.apiretrofit

import com.example.apiretrofit.models.LoginResponse
import com.example.apiretrofit.models.User

interface NetworkListener {
    fun onUsersResponse(models: LoginResponse?)
    fun onUsersFailure(message: String?)
}