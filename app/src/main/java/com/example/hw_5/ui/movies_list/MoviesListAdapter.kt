package com.example.hw_5.ui.movies_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw_5.data.model.list.Result
import com.example.hw_5.databinding.ItemMovieBinding

class MoviesListAdapter : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    var movies = emptyList<Result>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result) {
            with(binding) {
                tvName.text = item.originalTitle
                tvDate.text = item.releaseDate
                Glide.with(image)
                    .load(IMG_PATH_PREFIX + item.posterPath)
                    .fitCenter()
                    .into(image)

            }
        }
    }
    companion object{
        const val IMG_PATH_PREFIX = "https://image.tmdb.org/t/p/w500"
    }
}