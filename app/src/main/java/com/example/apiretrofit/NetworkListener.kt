package com.example.apiretrofit

import com.example.apiretrofit.models.SchoolClass

interface NetworkListener {
    fun onSchoolClassesResponse(models: List<SchoolClass>?)
    fun onSchoolClassesFailure(message: String?)
}