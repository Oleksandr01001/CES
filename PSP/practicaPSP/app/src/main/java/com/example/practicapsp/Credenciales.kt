package com.example.practicapsp

import java.io.Serializable

data class Credenciales(
    val usuario: String,
    val contrasena: String
) : Serializable
