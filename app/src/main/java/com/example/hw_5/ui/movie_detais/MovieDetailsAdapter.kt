package com.example.hw_5.ui.movie_detais

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_5.data.model.credits.CreditsResponse

class MovieDetailsAdapter() : RecyclerView.Adapter<MovieDetailsAdapter.ViewHolder>() {

    inner class ViewHolder(item: View, itemView: View): RecyclerView.ViewHolder(itemView){}

    var actors = emptyList<CreditsResponse>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}