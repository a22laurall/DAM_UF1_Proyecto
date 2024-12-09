package com.example.uf1_proyecto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.uf1_proyecto.data.factory.CategoryViewModelFactory
import com.example.uf1_proyecto.data.factory.RestaurantViewModelFactory
import com.example.uf1_proyecto.data.repository.CategoryRepository
import com.example.uf1_proyecto.data.repository.RestaurantRespository
import com.example.uf1_proyecto.data.viewmodel.CategoryViewModel
import com.example.uf1_proyecto.data.viewmodel.RestaurantViewModel
import com.example.uf1_proyecto.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding: FragmentCategoryBinding
        get() = _binding!!

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val view = binding.root

        val args = CategoryFragmentArgs.fromBundle(requireArguments())
        val restaurantId = args.restaurantId
        val menuId = args.menuId

        val application = requireContext().applicationContext as RestaurantApplication
        val repository = CategoryRepository(application.database.categoryDao())

        val factory = CategoryViewModelFactory(repository)
        categoryViewModel = ViewModelProvider(this, factory).get(CategoryViewModel::class.java)

        categoryViewModel.getCategoriesByMenuId(menuId).observe(viewLifecycleOwner) { categories ->
            categories.forEach { category ->

                when (category.name) {
                    "Entrantes" -> binding.buttonEntrantes.setOnClickListener {
                        navigateToMenuFragment(restaurantId, category.id)
                    }
                    "Principales" -> binding.buttonPrincipales.setOnClickListener {
                        navigateToMenuFragment(restaurantId, category.id)
                    }
                    "Postres" -> binding.buttonPostres.setOnClickListener {
                        navigateToMenuFragment(restaurantId, category.id)
                    }
                }
            }        }

        return view
    }


    private fun navigateToMenuFragment(restaurantId: Int, categoryId: Int) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToMenuFragment(restaurantId, categoryId)
        binding.root.findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
