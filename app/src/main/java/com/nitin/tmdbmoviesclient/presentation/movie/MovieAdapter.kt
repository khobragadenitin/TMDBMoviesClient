package com.nitin.tmdbmoviesclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nitin.tmdbmoviesclient.R
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    var movieList : List<Movie> = listOf()

    fun setMovies(movies : List<Movie>){
        this.movieList = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dataBinding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MovieViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.bind(movieList[position])

    override fun getItemCount(): Int = movieList.size

}

class MovieViewHolder(val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(movie : Movie){
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(binding.root.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}