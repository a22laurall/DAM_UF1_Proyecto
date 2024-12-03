package com.example.uf1_proyecto.data.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uf1_proyecto.data.repository.MenuItemRepository
import com.example.uf1_proyecto.data.viewmodel.MenuItemViewModel

class MenuItemViewModelFactory (private val repository: MenuItemRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(MenuItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MenuItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}