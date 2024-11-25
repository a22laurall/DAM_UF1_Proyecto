package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uf1_proyecto.databinding.FragmentHomeBinding
import com.example.uf1_proyecto.databinding.FragmentRestaurantBinding

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
        val restaurantName = args.restaurantName
        val view = binding.root

        binding.titleRestaurantName.text = restaurantName

        return view
    }

}