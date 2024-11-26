package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.uf1_proyecto.data.DataSource
import com.example.uf1_proyecto.databinding.FragmentRestaurantBinding
import com.example.uf1_proyecto.model.Restaurant

class RestaurantFragment : Fragment() {

    private var _binding: FragmentRestaurantBinding? = null
    private val binding: FragmentRestaurantBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        val args = RestaurantFragmentArgs.fromBundle(requireArguments())
        val restaurantId = args.restaurantId
        val view = binding.root

        // Asignar el nombre del restaurante
        val restaurant = DataSource().LoadRestaurantForId(restaurantId)
        binding.titleRestaurantName.text = getString(restaurant.stringResourceId)

        binding.buttonCarta.setOnClickListener{
            val action = RestaurantFragmentDirections.actionRestaurantFragmentToMenuFragment(restaurantId)
            view.findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}