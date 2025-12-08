package com.example.tienda.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoInformacion: DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Informacion de la APP")
        builder.setMessage("Esta app ha sido realizada para analizar datos de recycle view")


        return builder.create()
    }
}