package edu.iesam.dam2024.features

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.iesam.dam2024.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()
    }
    private fun setUpNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_1) as NavHostFragment
        val navController = navHostFragment.navController

        findViewById<BottomNavigationView>(R.id.main_menu).setupWithNavController(navController)
        navController.addOnDestinationChangedListener{_, destination, _ ->
            if(destination.id == R.id.rv_superhero
                || destination.id == R.id.rv_pokemon
                || destination.id == R.id.rv_movie){
                findViewById<BottomNavigationView>(R.id.main_menu).visibility = View.VISIBLE
            }
            else {
                findViewById<BottomNavigationView>(R.id.main_menu).visibility = View.GONE
            }

        }
    }
}