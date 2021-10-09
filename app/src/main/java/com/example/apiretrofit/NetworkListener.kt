package com.example.apiretrofit

import com.example.apiretrofit.models.User

interface NetworkListener {
    fun onUsersResponse(models: List<User>?)
    fun onUsersFailure(message: String?)
}