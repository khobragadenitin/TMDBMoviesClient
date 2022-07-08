package com.nitin.tmdbmoviesclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nitin.tmdbmoviesclient.R
import com.nitin.tmdbmoviesclient.databinding.ActivityHomeBinding
import com.nitin.tmdbmoviesclient.presentation.artist.ArtistActivity
import com.nitin.tmdbmoviesclient.presentation.movie.MovieActivity
import com.nitin.tmdbmoviesclient.presentation.tv.TvActivity

class HomeActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.moviesBtn.setOnClickListener {
            Intent(this, MovieActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.artistBtn.setOnClickListener {
            Intent(this, ArtistActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.tvShowBtn.setOnClickListener {
            Intent(this, TvActivity::class.java).apply {
                startActivity(this)
            }

        }



    }
}