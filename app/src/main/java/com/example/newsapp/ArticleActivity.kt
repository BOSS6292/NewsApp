package com.example.newsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import com.bumptech.glide.Glide

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val articleImage: ImageView = findViewById(R.id.image)
        val articleTitle: TextView = findViewById(R.id.title)
        val articleAuthor: TextView = findViewById(R.id.author)
        val articleDesc: TextView = findViewById(R.id.desc)
        val readMoreButton: Button = findViewById(R.id.read_more_button)

        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val desc = intent.getStringExtra("desc")
        val url = intent.getStringExtra("url")

        Glide.with(this)
            .load(image)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(articleImage)

        articleTitle.text = title
        articleAuthor.text = author
        articleDesc.text = desc

        readMoreButton.setOnClickListener {
            /*val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(urlIntent)*/

            val customTabsIntent = CustomTabsIntent.Builder().build()
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }
    }
}