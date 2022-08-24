package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val list: List<Article>, private val context:Context): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>()
{

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val newsImage:ImageView = itemView.findViewById(R.id.news_image)
        val titleText:TextView = itemView.findViewById(R.id.title_text)
        val descText:TextView = itemView.findViewById(R.id.desc_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int)
    {
        holder.titleText.text = list[position].title
        holder.descText.text = list[position].description

        Glide.with(context).load(list[position].urlToImage).into(holder.newsImage)

        val currentItem = list[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(context,ArticleActivity::class.java)
            val bundle = bundleOf("image" to currentItem.urlToImage,
            "title" to currentItem.title,
            "author" to currentItem.author,
            "desc" to currentItem.description,
            "url" to currentItem.url
            )
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int
    {
        return list.size
    }
}