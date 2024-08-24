package com.example.foodapp.model


data class Dish(
    val dishName: String,
    val dishId: String,
    val imageUrl: String,
    val isPublished: Boolean,
    var time: String? = null
)

