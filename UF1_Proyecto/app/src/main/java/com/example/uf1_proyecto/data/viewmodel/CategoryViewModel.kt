package com.example.uf1_proyecto.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uf1_proyecto.data.entity.Category
import com.example.uf1_proyecto.data.repository.CategoryRepository
import com.example.uf1_proyecto.data.entity.CategoryWithMenuItems
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    // Este es el LiveData para observar las categorías con los elementos del menú
    private val _categoryWithMenuItems = MutableLiveData<CategoryWithMenuItems>()
    val categoryWithMenuItems: LiveData<CategoryWithMenuItems> get() = _categoryWithMenuItems

    // Función para insertar una categoría
    fun insertCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.insertCategory(category)
        }
    }

    // Función para eliminar una categoría
    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.deleteCategory(category)
        }
    }

    // Función para actualizar una categoría
    fun updateCategory(category: Category) {
        viewModelScope.launch {
            categoryRepository.updateCategory(category)
        }
    }

    // Función para obtener una categoría con los elementos de menú asociados
    fun getCategoryWithMenuItems(categoryId: Int) {
        viewModelScope.launch {
            _categoryWithMenuItems.value = categoryRepository.getCategoryWithMenuItems(categoryId)
        }
    }

    fun getCategoriesByMenuId(menuId: Int): LiveData<List<Category>> {
        val categories = MutableLiveData<List<Category>>()
        viewModelScope.launch {
            categories.postValue(categoryRepository.getCategoriesByMenuId(menuId))
        }
        return categories
    }

}
