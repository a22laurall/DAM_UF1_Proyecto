package com.example.uf1_proyecto.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uf1_proyecto.data.repository.RestaurantRespository
import com.example.uf1_proyecto.data.viewmodel.RestaurantViewModel

class RestaurantViewModelFactory(private val repository: RestaurantRespository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RestaurantViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}