package com.example.modul5.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.modul5.data.MovieDetails
import com.example.modul5.databinding.FragmentDetailBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.movieDetails.collectLatest { details ->
                // Tampilkan atau sembunyikan loading
                binding.progressBar.isVisible = details == null
                binding.contentGroup.isVisible = details != null

                details?.let {
                    bindMovieDetails(it)
                }
            }
        }
    }

    private fun bindMovieDetails(details: MovieDetails) {
        with(binding) {
            moviePoster.load("https://image.tmdb.org/t/p/w500${details.posterPath}") {
                crossfade(true)
            }
            movieTitle.text = details.title
            movieOverview.text = details.overview

            // Info tambahan
            releaseYearText.text = "Tahun Rilis: ${details.releaseDate?.substring(0, 4) ?: "N/A"}"

            val director = details.credits.crew.find { it.job == "Director" }
            directorText.text = "Sutradara: ${director?.name ?: "N/A"}"

            val actors = details.credits.cast.take(3).joinToString(", ") { it.name }
            actorsText.text = "Aktor: $actors"

            // Logika Tombol Trailer
            val trailer = details.videos.results.find { it.site == "YouTube" && it.type == "Trailer" }
            if (trailer != null) {
                playTrailerButton.visibility = View.VISIBLE
                playTrailerButton.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${trailer.key}"))
                    startActivity(intent)
                }
            } else {
                playTrailerButton.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
