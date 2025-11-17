package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoraimc.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        acciones()

    }

    private fun acciones() {
        val imc = intent.getDoubleExtra("imc",0.0)
        val categoria = intent.getStringExtra("categoria")  ?: ""


        binding.imcResultado.text = "Tu IMC es: ${imc}"
        binding.textResultado.text = categoria



        val imagen = when(categoria) {
            "Bajo peso" -> R.drawable.estado1
            "Peso normal" -> R.drawable.estado2
            "Pre-obesidad o Sobrepeso" -> R.drawable.estado3
            "Obesidad clase I" -> R.drawable.estado4
            "Obesidad clase II" -> R.drawable.estado5
            else -> R.drawable.estado6


        }
        binding.imagenResultado.setImageResource(imagen)
    }


}