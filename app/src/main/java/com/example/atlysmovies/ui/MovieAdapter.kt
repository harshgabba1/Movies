package com.example.atlysmovies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.atlysmovies.data.Movie
import com.example.tmdbapp.databinding.ItemMovieBinding

class MovieAdapter(
    private val onClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    private val movies = mutableListOf<Movie>()


    fun submitList(newList: List<Movie>) {
        movies.clear()
        movies.addAll(newList)
        notifyDataSetChanged()
    }


    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movieName.text = movie.title
            Glide.with(binding.movieImage.context)
                .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
                .into(binding.movieImage)
            binding.root.setOnClickListener { onClick(movie) }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }


    override fun getItemCount() = movies.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.bind(movies[position])
}