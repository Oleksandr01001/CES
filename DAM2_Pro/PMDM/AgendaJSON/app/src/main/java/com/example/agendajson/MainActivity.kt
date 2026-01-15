package com.example.agendajson

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.adapter.UserAdapter
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.model.User
import com.google.gson.Gson
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listaUsers: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Agenda JSON"

        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        realizarPeticionJSON()
    }


    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"

        val peticionJSON = JsonObjectRequest(
            url,
            { response ->
                val gson = Gson()
                val usersArray: JSONArray = response.getJSONArray("users")

                listaUsers.clear()

                for (i in 0 until usersArray.length()) {
                    val userJSON = usersArray.getJSONObject(i)
                    val user: User = gson.fromJson(userJSON.toString(), User::class.java)
                    listaUsers.add(user)
                    Log.v("conexion", "El nombre del usuario es ${user.firstName}")
                }

                binding.rvUsers.adapter = UserAdapter(listaUsers) { user ->
                    mostrarDialogo(user)
                }
            },
            {
                Log.v("conexion", "Error en la conexion")
            }
        )

        Volley.newRequestQueue(this).add(peticionJSON)
    }

    private fun mostrarDialogo(user: User) {
        val view = LayoutInflater.from(this).inflate(R.layout.dialogo_user_info, null)

        view.findViewById<TextView>(R.id.tvNombre).text =
            "${user.firstName.orEmpty()} ${user.lastName.orEmpty()}"

        view.findViewById<TextView>(R.id.tvEmail).text =
            "Email: ${user.email.orEmpty()}"

        view.findViewById<TextView>(R.id.tvGenero).text =
            "Genero: ${user.gender.orEmpty()}"

        view.findViewById<TextView>(R.id.tvEdad).text =
            "Edad: ${user.age ?: "-"}"

        AlertDialog.Builder(this)
            .setTitle("Usuario")
            .setView(view)
            .setPositiveButton("Cerrar", null)
            .show()
    }


    override fun onCreateOptionsMenu(menu: android.view.Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_info -> {
                android.widget.Toast.makeText(this, "Toolbar", android.widget.Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
