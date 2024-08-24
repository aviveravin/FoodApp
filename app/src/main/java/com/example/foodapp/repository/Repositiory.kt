package com.example.foodapp.repository

import com.example.foodapp.model.Dish
import com.example.foodapp.model.DishModel

interface Repository {
    suspend fun getDishes(): List<Dish>
}
