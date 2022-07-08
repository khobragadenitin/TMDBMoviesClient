package com.nitin.tmdbmoviesclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nitin.tmdbmoviesclient.R
import com.nitin.tmdbmoviesclient.databinding.ActivityArtistBinding
import com.nitin.tmdbmoviesclient.presentation.di.Injector
import com.nitin.tmdbmoviesclient.presentation.movie.MovieAdapter
import com.nitin.tmdbmoviesclient.presentation.movie.MovieViewModel
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var dataBinding : ActivityArtistBinding
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter : ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_artist)
        supportActionBar?.title = "Artist"
        (application as Injector).getArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this,factory).get(ArtistViewModel::class.java)
        initRecyclerView()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = getMenuInflater()
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
        dataBinding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        dataBinding.artistRecyclerView.adapter = adapter
        loadData()
    }

    fun loadData(){
        dataBinding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtist()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                dataBinding.artistProgressBar.visibility = View.GONE
                adapter.setArtist(it)
                adapter.notifyDataSetChanged()
            }else{
                dataBinding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this,"No Data", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun updateData(){
        dataBinding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.updateArtist()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                dataBinding.artistProgressBar.visibility = View.GONE
                adapter.setArtist(it)
                adapter.notifyDataSetChanged()
            }else{
                dataBinding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this,"No Data", Toast.LENGTH_LONG).show()
            }
        })
    }
}