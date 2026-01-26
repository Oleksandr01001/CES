package com.example.agendajson.dataset

import com.example.agendajson.model.User

class FavData {

    companion object {

        private val favs = arrayListOf<User>()

        fun getAll(): List<User> {
            return favs
        }

        fun add(user: User): Boolean {
            if (favs.any { it.id == user.id }) return false
            favs.add(user)
            return true
        }

        fun remove(user: User): Boolean {
            return favs.removeIf { it.id == user.id }
        }

        fun isFav(user: User): Boolean {
            return favs.any { it.id == user.id }
        }
    }
}
