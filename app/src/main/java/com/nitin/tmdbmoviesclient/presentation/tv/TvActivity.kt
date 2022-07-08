package com.nitin.tmdbmoviesclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nitin.tmdbmoviesclient.R
import com.nitin.tmdbmoviesclient.databinding.ActivityArtistBinding
import com.nitin.tmdbmoviesclient.databinding.ActivityTvBinding

class TvActivity : AppCompatActivity() {


    private lateinit var dataBinding : ActivityTvBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_tv)
    }
}