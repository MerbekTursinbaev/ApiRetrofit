package com.example.apiretrofit.models

data class LoginResponse(val code : Int,
                         val message : String,
                         val payload : Payload,
                         val successful : Boolean)