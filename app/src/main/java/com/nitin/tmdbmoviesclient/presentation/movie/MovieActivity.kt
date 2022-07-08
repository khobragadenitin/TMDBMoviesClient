package com.nitin.tmdbmoviesclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nitin.tmdbmoviesclient.R
import com.nitin.tmdbmoviesclient.databinding.ActivityArtistBinding
import com.nitin.tmdbmoviesclient.databinding.ActivityMovieBinding
import com.nitin.tmdbmoviesclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MoviesViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var dataBinding : ActivityMovieBinding
    private lateinit var adapter : MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        supportActionBar?.title = "Movies"
        (application as Injector).getMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory).get(MovieViewModel::class.java)
        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater :MenuInflater = getMenuInflater()
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_update ->{
                updateData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    fun initRecyclerView(){
        dataBinding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        dataBinding.movieRecyclerView.adapter = adapter
        loadData()
    }

    fun loadData(){
        dataBinding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                dataBinding.movieProgressBar.visibility = View.GONE
                adapter.setMovies(it)
                adapter.notifyDataSetChanged()
            }else{
                dataBinding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this,"No Data",Toast.LENGTH_LONG).show()
            }
        })
    }

    fun updateData(){
        dataBinding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.updateMovies()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                dataBinding.movieProgressBar.visibility = View.GONE
                adapter.setMovies(it)
                adapter.notifyDataSetChanged()
            }else{
                dataBinding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this,"No Data",Toast.LENGTH_LONG).show()
            }
        })
    }


}