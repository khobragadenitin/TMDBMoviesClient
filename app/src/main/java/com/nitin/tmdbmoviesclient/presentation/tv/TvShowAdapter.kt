package com.nitin.tmdbmoviesclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nitin.tmdbmoviesclient.R
import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.data.model.tvshow.TVShow
import com.nitin.tmdbmoviesclient.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>() {

    var tvShowList : List<TVShow> = listOf()

    fun setTvShows(peoples : List<TVShow>){
        this.tvShowList = peoples
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dataBinding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return TvShowViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) = holder.bind(tvShowList[position])

    override fun getItemCount(): Int = tvShowList.size

}

class TvShowViewHolder(val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(tvShow : TVShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = "${tvShow.overview}"
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.root.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}