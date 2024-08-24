package com.example.foodapp.repository

import com.example.foodapp.model.Dish
import com.example.foodapp.service.ApiService

class RepositoryImpl(private val apiService: ApiService) : Repository {
    override suspend fun getDishes(): List<Dish> {
        return apiService.fetchDishes().map { dto ->
            Dish(
                dishName = dto.dishName,
                dishId = dto.dishId,
                imageUrl = dto.imageUrl,
                isPublished = dto.isPublished
            )
        }
    }
}
