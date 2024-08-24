package com.example.foodapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.model.Dish
import com.example.foodapp.usecase.GetDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val getDishesUseCase: GetDishesUseCase
) : ViewModel() {

    private val _dishes = MutableStateFlow<List<Dish>>(emptyList())
    val dishes: StateFlow<List<Dish>> = _dishes


    private val _selectedDish = MutableStateFlow<Dish?>(null)
    val selectedDish: StateFlow<Dish?> = _selectedDish

    init {
        fetchDishes()
    }

    fun setSelectedDish(dish: Dish) {
        _selectedDish.value = dish
    }

    private fun fetchDishes() {
        viewModelScope.launch {
            _dishes.value = getDishesUseCase()
        }
    }
}
