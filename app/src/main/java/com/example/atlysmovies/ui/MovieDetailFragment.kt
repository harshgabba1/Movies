package com.example.atlysmovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tmdbapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {


    private var _binding: FragmentDetailsBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = MovieDetailFragmentArgs.fromBundle(requireArguments())
        with(binding) {
            movieTitle.text = args.movieName
            movieDescription.text = args.movieDesc
        }
        Glide.with(binding.movieImage.context)
            .load("https://image.tmdb.org/t/p/w500${args.movieImage}")
            .into(binding.movieImage)


        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}