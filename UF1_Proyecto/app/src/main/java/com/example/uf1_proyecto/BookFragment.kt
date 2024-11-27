package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.uf1_proyecto.databinding.FragmentBookBinding

class BookFragment : Fragment() {

    private var _binding: FragmentBookBinding? = null
    private val binding: FragmentBookBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.editTextFechaHora.setOnClickListener{
            showDatePickerDialog()
        }

        binding.buttonReservar.setOnClickListener{
            val action = BookFragmentDirections.actionBookFragmentToReservationsFragment()
            view.findNavController().navigate(action)
        }

        return view
    }

    private fun showDatePickerDialog() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}