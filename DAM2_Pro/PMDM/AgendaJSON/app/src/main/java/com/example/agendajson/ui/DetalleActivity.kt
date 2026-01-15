package com.example.agendajson.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.agendajson.R
import com.example.agendajson.model.User

class DialogoInformacionUser(private val user: User) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.dialogo_user_info, null)

        view.findViewById<TextView>(R.id.tvNombre).text =
            "${user.firstName.orEmpty()} ${user.lastName.orEmpty()}"

        view.findViewById<TextView>(R.id.tvEmail).text =
            "Email: ${user.email.orEmpty()}"

        view.findViewById<TextView>(R.id.tvGenero).text =
            "Género: ${user.gender.orEmpty()}"

        view.findViewById<TextView>(R.id.tvEdad).text =
            "Edad: ${user.age ?: "-"}"

        return AlertDialog.Builder(requireContext())
            .setTitle("Información del usuario")
            .setView(view)
            .setPositiveButton("Cerrar", null)
            .create()
    }
}
