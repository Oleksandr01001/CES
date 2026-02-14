package com.example.spacexlaunches.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examenfinal.R
import com.example.spacexlaunches.data.FirebaseRepo
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private val repo = FirebaseRepo()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_login, container, false)

        val etEmail = v.findViewById<EditText>(R.id.etEmail)
        val etPass = v.findViewById<EditText>(R.id.etPass)
        val btn = v.findViewById<Button>(R.id.btnLogin)

        if (repo.currentUser() != null) {
            findNavController().navigate(R.id.action_loginFragment_to_launchesFragment)
            return v
        }

        btn.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val pass = etPass.text.toString().trim()

            if (email.isEmpty() || pass.isEmpty()) {
                Snackbar.make(v, "Rellena email y password", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            repo.signIn(email, pass,
                onOk = {
                    findNavController().navigate(R.id.action_loginFragment_to_launchesFragment)
                },
                onErr = { msg ->
                    repo.register(email, pass,
                        onOk = {
                            Snackbar.make(v, "Cuenta creada. Pulsa para iniciar sesión.", Snackbar.LENGTH_LONG)
                                .setAction("Iniciar sesión") {
                                    repo.signIn(email, pass,
                                        onOk = { findNavController().navigate(R.id.action_loginFragment_to_launchesFragment) },
                                        onErr = { e2 -> Snackbar.make(v, e2, Snackbar.LENGTH_LONG).show() }
                                    )
                                }
                                .show()
                        },
                        onErr = { e -> Snackbar.make(v, e, Snackbar.LENGTH_LONG).show() }
                    )
                }
            )
        }

        return v
    }
}
