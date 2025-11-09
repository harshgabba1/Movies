package com.example.atlysmovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tmdbapp.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieSearchFragment : Fragment() {


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!


    private val vm: MovieViewModel by viewModels()


    private lateinit var adapter: MovieAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MovieAdapter { movie ->
            val action =
                MovieSearchFragmentDirections.actionMovieSearchFragmentToMovieDetailFragment(
                    movie.title, movie.overview, movie.poster_path ?: ""
                )
            findNavController().navigate(action)
        }
        with(binding) {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerView.adapter = adapter
        }


        vm.movies.observe(viewLifecycleOwner) { adapter.submitList(it) }


        binding.searchBox.addTextChangedListener {
            vm.search(it.toString())
        }


        vm.fetchTrending()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}