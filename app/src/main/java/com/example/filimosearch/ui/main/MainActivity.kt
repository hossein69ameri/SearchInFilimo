package com.example.filimosearch.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filimosearch.R
import com.example.filimosearch.databinding.ActivityMainBinding
import com.example.filimosearch.util.NetworkResult
import com.example.filimosearch.util.extention.setupRecyclerView
import com.example.filimosearch.util.extention.visibilityLoading
import com.example.filimosearch.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var movieAdapter: MovieAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain)

        lifecycleScope.launchWhenCreated {
            viewModel.stateResponse.collectLatest {
                if (it != null) {
                    when (it.status) {
                        NetworkResult.Status.LOADING -> {
                            binding.progressBarMain.visibilityLoading(true, binding.recyclerMain)
                        }
                        NetworkResult.Status.SUCCESS -> {
                            binding.progressBarMain.visibilityLoading(false, binding.recyclerMain)
                            if (it.data != null) {
                               it.data.data?.let { itData ->
                                   movieAdapter.setData(itData)
                                   binding.recyclerMain.setupRecyclerView(LinearLayoutManager(this@MainActivity), movieAdapter)
                               }

                            }

                        }
                        NetworkResult.Status.ERROR -> {
                            binding.progressBarMain.visibilityLoading(false,binding.recyclerMain)
                            Toast.makeText(this@MainActivity,it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val search = menu.findItem(R.id.search_bar)
        val searchView = search.actionView as SearchView
        searchView.queryHint = getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.toString().isNotEmpty()){
                    if (newText != null) {
                        viewModel.searchMovie(newText)
                    }
                }
                return true
            }

        })
        return super.onCreateOptionsMenu(menu)

    }
}