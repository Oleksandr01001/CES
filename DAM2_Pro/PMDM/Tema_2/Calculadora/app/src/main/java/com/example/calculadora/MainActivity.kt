package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    var primerNumero: Double? = null
    var operacion: String? = null
    var nuevoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.boton0.setOnClickListener(this)
        binding.boton1.setOnClickListener(this)
        binding.boton2.setOnClickListener(this)
        binding.boton3.setOnClickListener(this)
        binding.boton4.setOnClickListener(this)
        binding.boton5.setOnClickListener(this)
        binding.boton6.setOnClickListener(this)
        binding.boton7.setOnClickListener(this)
        binding.boton8.setOnClickListener(this)
        binding.boton9.setOnClickListener(this)

        binding.botonMas.setOnClickListener(this)
        binding.botonMenos.setOnClickListener(this)
        binding.botonMultiplicar.setOnClickListener(this)
        binding.botonDividir.setOnClickListener(this)

        binding.botonRecet.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)

        binding.botonSin.setOnClickListener(this)
        binding.botonCos.setOnClickListener(this)
        binding.botonTan.setOnClickListener(this)
        binding.botonRaiz.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            binding.boton0.id,
            binding.boton1.id,
            binding.boton2.id,
            binding.boton3.id,
            binding.boton4.id,
            binding.boton5.id,
            binding.boton6.id,
            binding.boton7.id,
            binding.boton8.id,
            binding.boton9.id -> {
                val boton = v as Button
                val digito = boton.text.toString()
                val textoActual = binding.textoSuma.text.toString()

                val textoNuevo = if (nuevoNumero || textoActual == "0" || textoActual == "Error") {
                    nuevoNumero = false
                    digito
                } else {
                    textoActual + digito
                }

                binding.textoSuma.setText(textoNuevo)
            }

            binding.botonRecet.id -> {
                binding.textoSuma.setText("0")
                primerNumero = null
                operacion = null
                nuevoNumero = true
            }

            binding.botonMas.id,
            binding.botonMenos.id,
            binding.botonMultiplicar.id,
            binding.botonDividir.id -> {
                val valorActual = binding.textoSuma.text.toString().toDoubleOrNull()
                if (valorActual != null) {
                    primerNumero = valorActual
                    operacion = when (v.id) {
                        binding.botonMas.id -> "+"
                        binding.botonMenos.id -> "-"
                        binding.botonMultiplicar.id -> "*"
                        binding.botonDividir.id -> "/"
                        else -> null
                    }
                    nuevoNumero = true
                }
            }

            binding.botonIgual.id -> {
                val segundoNumero = binding.textoSuma.text.toString().toDoubleOrNull()
                if (primerNumero == null || operacion == null || segundoNumero == null) {
                    return
                }

                val resultado = when (operacion) {
                    "+" -> primerNumero!! + segundoNumero
                    "-" -> primerNumero!! - segundoNumero
                    "*" -> primerNumero!! * segundoNumero
                    "/" -> {
                        if (segundoNumero == 0.0) {
                            binding.textoSuma.setText("Error")
                            primerNumero = null
                            operacion = null
                            nuevoNumero = true
                            return
                        } else {
                            primerNumero!! / segundoNumero
                        }
                    }
                    else -> return
                }

                val textoResultado =
                    if (resultado % 1.0 == 0.0) resultado.toLong().toString() else resultado.toString()

                binding.textoSuma.setText(textoResultado)
                primerNumero = resultado
                nuevoNumero = true
            }

            binding.botonSin.id,
            binding.botonCos.id,
            binding.botonTan.id,
            binding.botonRaiz.id -> {
                val valorActual = binding.textoSuma.text.toString().toDoubleOrNull()
                if (valorActual == null) {
                    return
                }

                val resultado = when (v.id) {
                    binding.botonSin.id -> {
                        val rad = valorActual * PI / 180.0
                        sin(rad)
                    }
                    binding.botonCos.id -> {
                        val rad = valorActual * PI / 180.0
                        cos(rad)
                    }
                    binding.botonTan.id -> {
                        val rad = valorActual * PI / 180.0
                        tan(rad)
                    }
                    binding.botonRaiz.id -> {
                        if (valorActual < 0.0) {
                            binding.textoSuma.setText("Error")
                            nuevoNumero = true
                            return
                        } else {
                            sqrt(valorActual)
                        }
                    }
                    else -> return
                }

                val textoResultado =
                    if (resultado % 1.0 == 0.0) resultado.toLong().toString() else resultado.toString()

                binding.textoSuma.setText(textoResultado)
                primerNumero = resultado
                nuevoNumero = true
                operacion = null
            }
        }
    }
}
