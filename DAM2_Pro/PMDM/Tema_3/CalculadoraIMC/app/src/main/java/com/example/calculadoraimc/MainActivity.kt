package com.example.calculadoraimc

import android.content.Intent
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
            binding.botonCalcular.id -> {
                val alturaTexto = binding.textAltura.text.toString()
                val pesoTexto = binding.textPeso.text.toString()


                if (binding.textAltura.text.isNotEmpty() && binding.textPeso.text.isNotEmpty() && binding.radioGrupo.checkedRadioButtonId != -1) {

                    val altura = alturaTexto.toDouble()
                    val peso = pesoTexto.toDouble()
                    val masculino = binding.radioMasculino.isSelected

                    var categoria = ""


                    val imc = peso / (altura*altura)

                    if (masculino) {
                         categoria = when {
                            imc < 18.5 -> "Bajo peso"
                            imc < 25 -> "Peso normal"
                            imc < 30 -> "Pre-obesidad o Sobrepeso"
                            imc < 35 -> "Obesidad clase I"
                            imc < 40 -> "Obesidad clase II"
                            else -> "Obesidad clase III"
                        }
                    } else {
                         categoria = when {
                            imc < 16.5 -> "Bajo peso"
                            imc < 23 -> "Peso normal"
                            imc < 26 -> "Pre-obesidad o Sobrepeso"
                            imc < 31 -> "Obesidad clase I"
                            imc < 34 -> "Obesidad clase II"
                            else -> "Obesidad clase III"
                        }
                    }



                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("imc",imc)
                    intent.putExtra("categoria",categoria)
                    startActivity(intent)
                } else {
                    Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }


}