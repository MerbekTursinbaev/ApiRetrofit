package com.example.apiretrofit.models

data class GenericResponse<T>(val code : Int,
                           val message : String,
                           val payload : T,
                           val successful : Boolean)