package com.andreemeilio.submissiondicodingandroidpemula.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.andreemeilio.submissiondicodingandroidpemula.R
import com.andreemeilio.submissiondicodingandroidpemula.model.BookModel
import com.bumptech.glide.Glide

class ListBookAdapter(private val listBooks: ArrayList<BookModel>, private val onClickItem: ListItemOnClick): RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {
    
    class ListViewHolder(itemView: View): ViewHolder(itemView){
        val itemRvPhoto: ImageView = itemView.findViewById(R.id.itemRvPhoto)
        val itemRvJudul: TextView = itemView.findViewById(R.id.itemRvJudul)
        val itemRvPenulis: TextView = itemView.findViewById(R.id.itemRvPenulis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_book_recycler, parent, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listBooks.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (judul, penulis, sinopsis, cover) = listBooks[position]

        holder.itemRvJudul.text = judul
        holder.itemRvPenulis.text = penulis
        Glide.with(holder.itemView).load(cover).into(holder.itemRvPhoto)
        
        holder.itemView.setOnClickListener(onClickItem.onClick(position))
    }
    
    interface ListItemOnClick {
        fun onClick(position: Int): View.OnClickListener
    }
}