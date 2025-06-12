package com.example.modul5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer // Import Observer secara eksplisit
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.modul5.R
import com.example.modul5.data.Movie
import com.example.modul5.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tentukan tipe lambda secara eksplisit
        val adapter = MovieAdapter { movie: Movie ->
            viewModel.selectMovie(movie)
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter

        // Tentukan tipe data yang di-observe
        viewModel.movies.observe(viewLifecycleOwner, Observer<List<Movie>> { movies ->
            // Gunakan submitList untuk ListAdapter
            adapter.submitList(movies)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
