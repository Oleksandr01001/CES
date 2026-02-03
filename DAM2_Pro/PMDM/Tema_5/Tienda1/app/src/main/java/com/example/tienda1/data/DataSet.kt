package com.example.tienda1.data

import com.example.tienda1.model.User

class DataSet {
    companion object {
        val listaUsuarios: ArrayList<User> = ArrayList()
        fun registerUser(user: User): Boolean {
            if (listaUsuarios.find { it.correo == user.correo } != null) {
                return false
            } else {
                this.listaUsuarios.add(user)
                return true
            }
        }

        fun loginUser(correo: String, pass: String): User? {
            return listaUsuarios
                .find { it.correo == correo && it.pass == pass } ;
        }
    }
}