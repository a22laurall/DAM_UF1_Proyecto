package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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

        val args = BookFragmentArgs.fromBundle(requireArguments())
        val restaurantId = args.restaurantId

        // Obtener el array de horas de strings.xml
        val horarios = resources.getStringArray(R.array.horas_spinner)

        // Crear un adaptador para el Spinner
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, horarios)

        // Definir el estilo del Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asignar el adaptador al Spinner
        binding.spinnerHorarios.adapter = adapter

        binding.buttonReservar.setOnClickListener{
            val action = BookFragmentDirections.actionBookFragmentToReservationsFragment()
            view.findNavController().navigate(action)
        }

        return view
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(childFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        binding.editTextFechaHora.setText("$day/$month/$year")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}