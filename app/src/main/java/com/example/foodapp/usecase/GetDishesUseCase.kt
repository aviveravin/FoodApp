package com.example.foodapp.usecase

import com.example.foodapp.model.Dish
import com.example.foodapp.repository.Repository


class GetDishesUseCase(private val repository: Repository) {
    suspend operator fun invoke(): List<Dish> {
        return repository.getDishes()
    }
}