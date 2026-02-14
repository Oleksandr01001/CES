package com.example.spacexlaunches.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenfinal.databinding.FragmentLaunchesBinding
import com.example.spacexlaunches.data.FirebaseRepo
import com.example.spacexlaunches.model.FavoriteLaunch
import com.example.spacexlaunches.model.Launch
import com.example.spacexlaunches.ui.adapter.LaunchAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*

class LaunchesFragment : Fragment() {

    private var _b: FragmentLaunchesBinding? = null
    private val b get() = _b!!

    private val repo = FirebaseRepo()
    private lateinit var adapter: LaunchAdapter

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _b = FragmentLaunchesBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = LaunchAdapter(emptyList()) { launch ->
            if (repo.currentUser() == null) {
                Snackbar.make(requireView(), "Necesitas sesión para favoritos", Snackbar.LENGTH_SHORT).show()
                return@LaunchAdapter
            }

            val fav = FavoriteLaunch(
                id = launch.id,
                name = launch.name,
                details = launch.details,
                imageUrl = launch.links?.patch?.small
            )

            repo.addFavorite(
                fav,
                onOk = { Snackbar.make(requireView(), "Añadido a favoritos", Snackbar.LENGTH_SHORT).show() },
                onErr = { e -> Snackbar.make(requireView(), e, Snackbar.LENGTH_LONG).show() }
            )
        }

        b.recycler.layoutManager = LinearLayoutManager(requireContext())
        b.recycler.adapter = adapter

        loadLaunches()
    }

    private fun loadLaunches() {
        scope.launch {
            try {
                val data: List<Launch> = withContext(Dispatchers.IO) {

                }
                adapter.update(data)
            } catch (e: Exception) {
                if (!isAdded) return@launch
                Snackbar.make(requireView(), "Error API: ${e.message}", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        scope.cancel()
        _b = null
    }
}
