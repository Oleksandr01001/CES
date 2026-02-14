package com.example.spacexlaunches.data

import com.example.spacexlaunches.model.FavoriteLaunch
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class FirebaseRepo {

    private val auth = FirebaseAuth.getInstance()

    private val dbUrl = "https://examoh-2526-default-rtdb.europe-west1.firebasedatabase.app/"
    private val root = FirebaseDatabase.getInstance(dbUrl).reference

    fun currentUser() = auth.currentUser

    fun signIn(email: String, pass: String, onOk: () -> Unit, onErr: (String) -> Unit) {
        auth.signInWithEmailAndPassword(email, pass)
            .addOnSuccessListener { onOk() }
            .addOnFailureListener { e -> onErr(e.message ?: "Login error") }
    }

    fun register(email: String, pass: String, onOk: () -> Unit, onErr: (String) -> Unit) {
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnSuccessListener { onOk() }
            .addOnFailureListener { e -> onErr(e.message ?: "Register error") }
    }

    fun logout() {
        auth.signOut()
    }

    private fun favRef(uid: String) = root.child("favorites").child(uid)

    fun addFavorite(launch: FavoriteLaunch, onOk: () -> Unit, onErr: (String) -> Unit) {
        val uid = auth.currentUser?.uid ?: run {
            onErr("No session")
            return
        }
        val id = launch.id ?: run {
            onErr("No id")
            return
        }

        favRef(uid).child(id).setValue(launch)
            .addOnSuccessListener { onOk() }
            .addOnFailureListener { e -> onErr(e.message ?: "Error adding favorite") }
    }

    fun removeFavorite(launchId: String, onOk: () -> Unit, onErr: (String) -> Unit) {
        val uid = auth.currentUser?.uid ?: run {
            onErr("No session")
            return
        }
        favRef(uid).child(launchId).removeValue()
            .addOnSuccessListener { onOk() }
            .addOnFailureListener { e -> onErr(e.message ?: "Error removing favorite") }
    }

    fun listenFavorites(onData: (List<FavoriteLaunch>) -> Unit) {
        val uid = auth.currentUser?.uid ?: run {
            onData(emptyList())
            return
        }

        favRef(uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<FavoriteLaunch>()
                for (child in snapshot.children) {
                    val fav = child.getValue(FavoriteLaunch::class.java)
                    if (fav != null) list.add(fav)
                }
                onData(list)
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }
}
