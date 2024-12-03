package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.uf1_proyecto.data.Restaurant
import com.example.uf1_proyecto.data.factory.RestaurantViewModelFactory
import com.example.uf1_proyecto.data.repository.RestaurantRespository
import com.example.uf1_proyecto.data.viewmodel.RestaurantViewModel
import com.example.uf1_proyecto.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment() {

    private var _binding: FragmentRestaurantBinding? = null
    private val binding: FragmentRestaurantBinding
        get() = _binding!!

    private lateinit var restaurantViewModel: RestaurantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        val view = binding.root

        val args = RestaurantFragmentArgs.fromBundle(requireArguments())
        val restaurantId = args.restaurantId

        val application = requireContext().applicationContext as RestaurantApplication
        val repository = RestaurantRespository(application.database.restaurantDao())

        val factory = RestaurantViewModelFactory(repository)
        restaurantViewModel = ViewModelProvider(this, factory).get(RestaurantViewModel::class.java)


        // Observar los datos del restaurante

        restaurantViewModel.getRestaurantWithMenu(restaurantId).observe(viewLifecycleOwner) { restaurantWithMenu ->
            restaurantWithMenu?.let { restaurantMenu ->
                updateUI(restaurantMenu.restaurant)

                // Configurar la navegación al fragmento de categorías usando el `menuId`
                binding.buttonCarta.setOnClickListener {
                    val menuId = restaurantMenu.menu.id
                    val action = RestaurantFragmentDirections.actionRestaurantFragmentToCategoryFragment(menuId, restaurantId)
                    view.findNavController().navigate(action)
                }
            }
        }

        binding.buttonReservar.setOnClickListener {
            val action = RestaurantFragmentDirections.actionRestaurantFragmentToBookFragment()
            view.findNavController().navigate(action)
        }

        return view
    }

    private fun updateUI(restaurant: Restaurant) {
        binding.titleRestaurantName.text = restaurant.name
        binding.direction.text = restaurant.direction
        binding.restaurantImage.setImageResource(restaurant.drawableResourceId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}