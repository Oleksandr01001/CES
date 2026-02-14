package com.example.spacexlaunches.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenfinal.R
import com.example.examenfinal.databinding.FragmentFavoritesBinding
import com.example.spacexlaunches.data.FirebaseRepo
import com.example.spacexlaunches.model.Launch
import com.example.spacexlaunches.ui.adapter.LaunchAdapter

class FavoritesFragment : Fragment() {

    private var _b: FragmentFavoritesBinding? = null
    private val b get() = _b!!
    private val repo = FirebaseRepo()

    private lateinit var adapter: LaunchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _b = FragmentFavoritesBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (repo.currentUser() == null) {
            AlertDialog.Builder(requireContext())
                .setTitle("Aviso")
                .setMessage("Debes iniciar sesión para ver favoritos.")
                .setPositiveButton("OK") { _, _ ->
                    findNavController().navigate(R.id.loginFragment)
                }
                .show()
            return
        }

        adapter = LaunchAdapter(emptyList()) {  }

        b.recyclerFav.layoutManager = LinearLayoutManager(requireContext())
        b.recyclerFav.adapter = adapter

        repo.listenFavorites { favs ->
            val launches = favs.map { f ->
                Launch(
                    id = f.id,
                    name = f.name,
                    details = f.details,
                    links = Launch.Links(Launch.Patch(f.imageUrl))
                )
            }
            adapter.update(launches)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }
}
