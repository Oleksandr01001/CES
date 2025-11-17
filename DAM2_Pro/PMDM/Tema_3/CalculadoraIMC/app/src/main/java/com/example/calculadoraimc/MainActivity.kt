package com.example.calculadoraimc

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoraimc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.botonCalcular -> {
                if (binding.textAltura.text.isNotEmpty() && binding.textPeso.text.isNotEmpty()) {

                } else {
                    Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_LONG)
                }
            }
        }
    }


}