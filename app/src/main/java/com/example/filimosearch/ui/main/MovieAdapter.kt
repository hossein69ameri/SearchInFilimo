package com.example.filimosearch.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.filimosearch.data.model.ResponseSearch
import com.example.filimosearch.data.model.ResponseSearch.Data
import com.example.filimosearch.databinding.ItemMovieBinding
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var binding: ItemMovieBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //getItem from PagingDataAdapter
        holder.bind(differ.currentList[position])
        //Not duplicate items
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = differ.currentList.size

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Data) {
            binding.apply {
                movieNameTxt.text = item.attributes?.movieTitle
                movieCountryTxt.text = item.attributes?.countries?.get(0)?.country.toString()
                movieMoreTxt.text = item.attributes?.descr.toString()
                movieRateTxt.text = item.attributes?.imdbRate.toString()
                movieYearTxt.text = item.attributes?.proYear.toString()
                moviePosterImg.load(item.attributes?.pic?.movieImgB){
                    crossfade(true)
                    crossfade(500)
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}