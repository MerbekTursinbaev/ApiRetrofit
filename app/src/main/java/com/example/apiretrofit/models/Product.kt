package com.example.apiretrofit.models

data class Product(
    val brand : String,
    val category_id : String,
    val conditions : String,
    val description : String,
    val full_image : String,
    val id  : Int,
    val image : String,
    val keeping : Int,
    val mode_app: String,
    val name : String,
    val point : Int,
    val price : Int
)