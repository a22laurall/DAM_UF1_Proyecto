package com.example.uf1_proyecto.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uf1_proyecto.entity.Menu
import com.example.uf1_proyecto.data.repository.MenuRepository
import com.example.uf1_proyecto.entity.MenuWithCategories
import kotlinx.coroutines.launch

class MenuViewModel(private val menuRepository: MenuRepository): ViewModel() {

    private val _menuWithCategories = MutableLiveData<MenuWithCategories>()
    val menuWithCategories: LiveData<MenuWithCategories> get() = _menuWithCategories

    fun insertMenu(menu: Menu){
        viewModelScope.launch {
            menuRepository.insertMenu(menu)
        }
    }

    fun deleteMenu(menu: Menu){
        viewModelScope.launch {
            menuRepository.deleteMenu(menu)
        }
    }

    fun updateMenu(menu: Menu){
        viewModelScope.launch {
            menuRepository.updateMenu(menu)
        }
    }

    // Función para obtener un menú con sus categorías
    fun getMenuWithCategories(menuId: Int) {
        viewModelScope.launch {
            _menuWithCategories.value = menuRepository.getMenuWithCategories(menuId)
        }
    }
}