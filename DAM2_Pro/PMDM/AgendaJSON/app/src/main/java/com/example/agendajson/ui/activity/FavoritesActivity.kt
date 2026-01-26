package com.example.agendajson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendajson.adapter.UserAdapter
import com.example.agendajson.databinding.ActivityFavoritesBinding
import com.example.agendajson.dataset.FavData
import com.example.agendajson.model.User
import com.example.agendajson.ui.dialog.DialogUser
import com.google.android.material.snackbar.Snackbar

class FavoritesActivity : AppCompatActivity(), UserAdapter.OnItemUserListener {

    private lateinit var binding: ActivityFavoritesBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter(this)
        binding.recyclerFavs.adapter = adapter
        binding.recyclerFavs.layoutManager = LinearLayoutManager(this)

        cargarFavs()
    }

    private fun cargarFavs() {
        adapter.clearUsers()
        FavData.getAll().forEach { adapter.addUSer(it) }
    }

    override fun onUserDetailSelected(user: User) {
        DialogUser.newInstance(user).show(supportFragmentManager, null)
    }

    override fun onUserAddFavSelected(user: User) {
        Snackbar.make(binding.root, "Ya está en favoritos", Snackbar.LENGTH_SHORT).show()
    }

    override fun onUserRemoveFavSelected(user: User) {
        val removed = FavData.remove(user)
        if (removed) {
            cargarFavs()
            Snackbar.make(binding.root, "Eliminado de favoritos", Snackbar.LENGTH_SHORT).show()
        }
    }
}
