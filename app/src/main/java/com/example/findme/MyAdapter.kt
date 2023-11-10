package com.example.findme

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context : Activity, val dataList : List<Result>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val image : ImageView
        val title : TextView
        val caption : TextView
        val releaseDate : TextView

        init {
            image = itemView.findViewById(R.id.MyImage)
            title = itemView.findViewById(R.id.MovieName)
            releaseDate = itemView.findViewById(R.id.releaseDate)
            caption = itemView.findViewById(R.id.caption)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.items, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = dataList[position]

        holder.title.text = current.originalTitleText.text
        holder.caption.text = current.primaryImage.caption.plainText
        Picasso.get().load(current.primaryImage.url).into(holder.image)
        holder.releaseDate.text = current.releaseYear.year.toString()

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}