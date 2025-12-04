package com.example.examen_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_2.databinding.ActivityMainBinding
import com.example.examen_2.ui.SecondActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        acciones()
    }

    private fun acciones() {
        binding.botonAceptar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id) {

            binding.botonAceptar.id -> {

                val nombre = binding.textNombre.text.toString()
                val matricula = binding.textMatricula.text.toString()
                val ano = binding.textAnoMatricula.text.toString()
                val autonomia = binding.textAutomia.text.toString()
                val tipo = binding.tipoCoche.text.toString()



                if(nombre.isEmpty() || matricula.isEmpty() || ano.isEmpty() || autonomia.isEmpty() || tipo.isEmpty()) {
                    Snackbar.make(v,"Faltan datos", Snackbar.LENGTH_LONG).show()
                } else {
                    val intent = Intent(applicationContext, SecondActivity::class.java)
                    intent.putExtra("nombre",nombre)
                    intent.putExtra("matricula",matricula)
                    intent.putExtra("ano",ano)
                    intent.putExtra("autonomia",autonomia)
                    intent.putExtra("tipo",tipo)

                    startActivity(intent)
                }

            }

        }
    }
}