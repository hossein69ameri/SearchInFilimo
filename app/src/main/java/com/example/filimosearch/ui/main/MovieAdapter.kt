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
    private var moviesList = emptyList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //getItem from PagingDataAdapter
        holder.bind(moviesList[position])
        //Not duplicate items
        holder.setIsRecyclable(false)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount() = moviesList.size

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

    fun setData(data: List<Data>) {
        val moviesDiffUtil = NotesDiffUtils(moviesList, data)
        val diffUtils = DiffUtil.calculateDiff(moviesDiffUtil)
        moviesList = data
        diffUtils.dispatchUpdatesTo(this)
    }

    class NotesDiffUtils(private val oldItem: List<Data>, private val newItem: List<Data>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldItem.size
        }

        override fun getNewListSize(): Int {
            return newItem.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }
    }
}