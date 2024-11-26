package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.uf1_proyecto.adapter.ItemAdapter
import com.example.uf1_proyecto.data.DataSource
import com.example.uf1_proyecto.data.MenuDataSource
import com.example.uf1_proyecto.databinding.FragmentHomeBinding
import com.example.uf1_proyecto.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cargar el dataset
        val dataset = MenuDataSource().LoadMenuForRestaurant()

        // Configurar el RecyclerView
        val recyclerView = binding.recyclerViewMenuFragment
        recyclerView.adapter = ItemAdapter(
            requireContext(), dataset)
        recyclerView.setHasFixedSize(true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}