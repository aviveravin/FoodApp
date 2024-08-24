package com.example.foodapp.service

import com.example.foodapp.model.DishModel
import retrofit2.http.GET

interface ApiService {
    @GET("dev/nosh-assignment")
    suspend fun fetchDishes(): List<DishModel>
}
