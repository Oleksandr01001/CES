package com.example.examen_2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examen_2.R
import com.example.examen_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        val nombre = intent.getStringExtra("nombre")
        val matricula = intent.getStringExtra("matricula")
        val ano = intent.getStringExtra("ano")
        val autonomia = intent.getStringExtra("autonomia")
        val tipo = intent.getStringExtra("tipo")



        binding.text2Nombre.setText(nombre)
        binding.text2Matricula.setText(matricula)
        binding.text2AnoMatricula.setText(ano)
        binding.text2Autonomia.setText(autonomia)
        binding.text2TipoG.setText(tipo)




        val imagen = when(tipo) {
            "electrico" -> R.drawable.etiqueta0
            "" -> R.drawable.etiqueta0
            "" -> R.drawable.etiquetab
            "disel" -> R.drawable.etiquetac
            "eco" -> R.drawable.etiquetaeco
            "hibrido" -> R.drawable.etiquetaeco

            else -> R.drawable.etiquetab


        }
        binding.imagen.setImageResource(imagen)

    }
}