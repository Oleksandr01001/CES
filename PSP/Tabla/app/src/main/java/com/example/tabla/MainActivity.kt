package com.example.tabla

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tabla.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener { mostrarTablas() }
    }

    private fun mostrarTablas() {
        binding.tvOutput.text = ""

        lifecycleScope.launch(Dispatchers.Default) {
            val jobs = mutableListOf<Job>()

            for (table in 1..10) {
                val job = launch {
                    val sb = StringBuilder()
                    sb.append("La tabla del $table\n")
                    for (i in 1..10) {
                        sb.append("$table * $i = ${table * i}\n")
                    }
                    withContext(Dispatchers.Main) {
                        binding.tvOutput.append(sb.toString() + "\n")
                    }
                }
                jobs.add(job)
            }

            jobs.joinAll()
        }
    }
}