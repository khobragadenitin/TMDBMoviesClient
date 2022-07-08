package com.nitin.tmdbmoviesclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nitin.tmdbmoviesclient.R
import com.nitin.tmdbmoviesclient.data.model.artist.People
import com.nitin.tmdbmoviesclient.data.model.movie.Movie
import com.nitin.tmdbmoviesclient.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {

    var peopleList : List<People> = listOf()

    fun setArtist(peoples : List<People>){
        this.peopleList = peoples
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dataBinding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return ArtistViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) = holder.bind(peopleList[position])

    override fun getItemCount(): Int = peopleList.size

}

class ArtistViewHolder(val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(people : People){
        binding.titleTextView.text = people.name
        binding.descriptionTextView.text = "${people.popularity}"
        val posterURL = "https://image.tmdb.org/t/p/w500"+people.profilePath
        Glide.with(binding.root.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}