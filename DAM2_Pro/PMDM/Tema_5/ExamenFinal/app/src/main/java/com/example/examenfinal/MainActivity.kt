package com.example.spacexlaunches

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.examenfinal.R
import com.example.examenfinal.databinding.ActivityMainBinding
import com.example.spacexlaunches.data.FirebaseRepo

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding
    private val repo = FirebaseRepo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        setSupportActionBar(b.toolbar)

        val navController = findNavController(R.id.nav_host)
        setupActionBarWithNavController(navController)

        b.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_favorites -> {
                    if (repo.currentUser() == null) {
                        Toast.makeText(this, "Necesitas sesión para ver favoritos", Toast.LENGTH_SHORT).show()
                    } else {
                        navController.navigate(R.id.favoritesFragment)
                    }
                    true
                }
                R.id.menu_logout -> {
                    repo.logout()
                    Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.loginFragment)
                    true
                }
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host).navigateUp() || super.onSupportNavigateUp()
    }
}
