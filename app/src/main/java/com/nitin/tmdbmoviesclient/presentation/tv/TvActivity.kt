package com.nitin.tmdbmoviesclient.presentation.tv

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
import com.nitin.tmdbmoviesclient.databinding.ActivityTvBinding
import com.nitin.tmdbmoviesclient.presentation.artist.ArtistAdapter
import com.nitin.tmdbmoviesclient.presentation.artist.ArtistViewModel
import com.nitin.tmdbmoviesclient.presentation.di.Injector
import javax.inject.Inject

class TvActivity : AppCompatActivity() {


    @Inject
    lateinit var factory : TvViewModelProvider
    private lateinit var dataBinding : ActivityTvBinding
    private lateinit var tvViewModel: TvViewModel
    private lateinit var adapter : TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_tv)
        supportActionBar?.title = "Tv Shows"
        (application as Injector).getTvShowSubComponent().inject(this)
        tvViewModel = ViewModelProvider(this,factory).get(TvViewModel::class.java)
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
        dataBinding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        dataBinding.tvRecyclerView.adapter = adapter
        loadData()
    }

    fun loadData(){
        dataBinding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                dataBinding.tvProgressBar.visibility = View.GONE
                adapter.setTvShows(it)
                adapter.notifyDataSetChanged()
            }else{
                dataBinding.tvProgressBar.visibility = View.GONE
                Toast.makeText(this,"No Data", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun updateData(){
        dataBinding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvViewModel.updateTvShows()
        responseLiveData.observe(this, Observer {
            if (it!=null){
                dataBinding.tvProgressBar.visibility = View.GONE
                adapter.setTvShows(it)
                adapter.notifyDataSetChanged()
            }else{
                dataBinding.tvProgressBar.visibility = View.GONE
                Toast.makeText(this,"No Data", Toast.LENGTH_LONG).show()
            }
        })
    }
}