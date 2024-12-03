package com.example.uf1_proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.uf1_proyecto.adapter.MenuItemAdapter
import com.example.uf1_proyecto.data.factory.CategoryViewModelFactory
import com.example.uf1_proyecto.data.factory.MenuItemViewModelFactory
import com.example.uf1_proyecto.data.repository.CategoryRepository
import com.example.uf1_proyecto.data.repository.MenuItemRepository
import com.example.uf1_proyecto.data.viewmodel.CategoryViewModel
import com.example.uf1_proyecto.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding!!

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        val args = MenuFragmentArgs.fromBundle(requireArguments())
        val restaurantId = args.restaurantId
        val categoryId = args.categoryId


        val application = requireContext().applicationContext as RestaurantApplication
        val repository = CategoryRepository(application.database.categoryDao())

        val factory = CategoryViewModelFactory(repository)
        categoryViewModel = ViewModelProvider(this, factory).get(CategoryViewModel::class.java)


        categoryViewModel.categoryWithMenuItems.observe(viewLifecycleOwner, { categoryWithMenuItems ->
            // Asegúrate de que categoryWithMenuItems no sea nulo
            categoryWithMenuItems?.let { categoryWithMenuItemsData ->
                // Extraer los MenuItems de la categoría
                val menuItems = categoryWithMenuItemsData.items ?: emptyList()

                // Configura el RecyclerView
                val recyclerView = binding.recyclerViewMenuFragment
                recyclerView.adapter = MenuItemAdapter(requireContext(), menuItems)
                recyclerView.setHasFixedSize(true)

                // Actualiza el TextView con el nombre de la categoría
                binding.textViewCategoryName.text = categoryWithMenuItemsData.category.name
            }
        })


        categoryViewModel.getCategoryWithMenuItems(categoryId)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}