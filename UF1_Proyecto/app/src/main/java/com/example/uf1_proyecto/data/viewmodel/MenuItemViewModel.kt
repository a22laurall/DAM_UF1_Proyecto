package com.example.uf1_proyecto.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uf1_proyecto.entity.MenuItem
import com.example.uf1_proyecto.data.repository.MenuItemRepository
import kotlinx.coroutines.launch

class MenuItemViewModel(private val menuItemRepository: MenuItemRepository): ViewModel() {

    fun insertMenuItem(menuItem: MenuItem){
        viewModelScope.launch {
            menuItemRepository.insertMenuItem(menuItem)
        }
    }

    fun updateMenuItem(menuItem: MenuItem){
        viewModelScope.launch {
            menuItemRepository.updateMenuItem(menuItem)
        }
    }

    fun deleteMenuItem(menuItem: MenuItem){
        viewModelScope.launch {
            menuItemRepository.deleteMenuItem(menuItem)
        }
    }
}