package com.example.holamundo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Для коректного відображення поверх системних панелей
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Зв’язуємо елементи
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val imgPhoto = findViewById<ImageView>(R.id.imgPhoto)


        btnShow.setOnClickListener {
            val text = "В клан йому важко зайти, я в афігу..."
            tvResult.text = text
            imgPhoto.setImageResource(R.drawable.my_photo) // файл у res/drawable/
            imgPhoto.visibility = View.VISIBLE
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}
