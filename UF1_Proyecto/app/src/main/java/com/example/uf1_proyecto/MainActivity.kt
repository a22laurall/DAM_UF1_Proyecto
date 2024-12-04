package com.example.uf1_proyecto

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.uf1_proyecto.data.app.AppDatabase
import com.example.uf1_proyecto.data.repository.RestaurantRespository
import com.example.uf1_proyecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Se iniciará mas tarde, antes de su uso y no será nula
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        val database by lazy { AppDatabase.getDatabase(this) }
        val repository by lazy { RestaurantRespository(database.restaurantDao()) }

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        // Configura el BottomNavigationView con el NavController
        val bottomNav = binding.bottomNavigation
        bottomNav.setupWithNavController(navController)
        setContentView(view)
    }
}