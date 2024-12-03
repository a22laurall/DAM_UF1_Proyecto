package com.example.uf1_proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.uf1_proyecto.adapter.ItemAdapter
import com.example.uf1_proyecto.data.factory.RestaurantViewModelFactory
import com.example.uf1_proyecto.data.repository.RestaurantRespository
import com.example.uf1_proyecto.data.viewmodel.RestaurantViewModel
import com.example.uf1_proyecto.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!

    private lateinit var restaurantViewModel: RestaurantViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContext = requireContext().applicationContext as RestaurantApplication

        val dao = appContext.database.restaurantDao()
        val repository = RestaurantRespository(dao)

        // Crear el ViewModel usando la Factory personalizada
        val factory = RestaurantViewModelFactory(repository)
        restaurantViewModel = ViewModelProvider(this, factory).get(RestaurantViewModel::class.java)


        // Observa el LiveData de los restaurantes
        restaurantViewModel.allRestaurants.observe(viewLifecycleOwner, { restaurants ->
            // Configura el RecyclerView con la lista de restaurantes
            val recyclerView = binding.recyclerView
            recyclerView.adapter = ItemAdapter(
                requireContext(), restaurants,  // Pasamos los restaurantes desde el LiveData
                onItemClick = { restaurant ->
                    val restaurantId = restaurant.id
                    view.findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToRestaurantFragment(restaurantId)
                    )
                }
            )
            recyclerView.setHasFixedSize(true)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
