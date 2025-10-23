package com.example.contador

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var contador: Int = 0
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contador = savedInstanceState?.getInt("tag_contador") ?: 0
        binding.textoContador.text = contador.toString()

        acciones()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("tag_contador",contador)
    }

    private fun acciones() {
        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremeto.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonIncremento.id->{contador++}
            binding.botonDecremeto.id->{contador--}

        }
        binding.textoContador.text = contador.toString()
    }

}