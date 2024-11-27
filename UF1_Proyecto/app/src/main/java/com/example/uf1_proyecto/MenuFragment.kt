package com.example.uf1_proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.adapter.MenuItemAdapter
import com.example.uf1_proyecto.data.MenuDataSource
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

        val args = MenuFragmentArgs.fromBundle(requireArguments())
        val restaurantId = args.restaurantId
        val category_name = args.categoryName
        val view = binding.root

        binding.textViewCategoryName.text = category_name
        val dataset = MenuDataSource().LoadMenuForRestaurant(restaurantId, category_name)

        val recyclerView = binding.recyclerViewMenuFragment
        recyclerView.adapter = MenuItemAdapter(requireContext(), dataset)
        recyclerView.setHasFixedSize(true)
        

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}