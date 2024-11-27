package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.uf1_proyecto.databinding.FragmentCategoryBinding
import com.example.uf1_proyecto.databinding.FragmentRestaurantBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding: FragmentCategoryBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.buttonEntrantes.setOnClickListener{
            val action = CategoryFragmentDirections.actionCategoryFragmentToMenuFragment2()
            view.findNavController().navigate(action)
        }

        binding.buttonPrincipales.setOnClickListener{
            val action = CategoryFragmentDirections.actionCategoryFragmentToMenuFragment2()
            view.findNavController().navigate(action)
        }

        binding.buttonPostres.setOnClickListener{
            val action = CategoryFragmentDirections.actionCategoryFragmentToMenuFragment2()
            view.findNavController().navigate(action)
        }

        return view
    }

}