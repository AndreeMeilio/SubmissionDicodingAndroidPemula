package com.andreemeilio.submissiondicodingandroidpemula

import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.andreemeilio.submissiondicodingandroidpemula.model.BookModel
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val BOOK_EXTRA = "book_extra"
    }

    private lateinit var detailCover: ImageView
    private lateinit var detailJudul: TextView
    private lateinit var detailPenulis: TextView
    private lateinit var detailRating: TextView
    private lateinit var detailFormat: TextView
    private lateinit var detailPublished: TextView
    private lateinit var detailIsbn: TextView
    private lateinit var detailAsin: TextView
    private lateinit var detailLanguage: TextView
    private lateinit var detailDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(findViewById(R.id.detailActionBar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailCover = findViewById(R.id.detailCoverBuku)
        detailJudul = findViewById(R.id.detailJudulBuku)
        detailPenulis = findViewById(R.id.detailPenulisBuku)
        detailRating = findViewById(R.id.detailRatingBuku)
        detailFormat = findViewById(R.id.detailFormatValue)
        detailPublished = findViewById(R.id.detailPublishedValue)
        detailIsbn = findViewById(R.id.detailIsbnValue)
        detailAsin = findViewById(R.id.detailAsinValue)
        detailLanguage = findViewById(R.id.detailLanguageValue)
        detailDescription = findViewById(R.id.detailDescriptionValue)

        val data: BookModel? = if (VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getParcelableExtra(DetailActivity.BOOK_EXTRA, BookModel::class.java)
        } else {
            intent.getParcelableExtra<BookModel>(DetailActivity.BOOK_EXTRA)
        }

        Glide.with(this@DetailActivity).load(data?.cover).into(detailCover)
        detailJudul.text = data?.judul ?: "-"
        detailPenulis.text = data?.penulis ?: "-"
        detailRating.text = "Rating : ${data?.rating}"
        detailFormat.text = data?.format ?: "-"
        detailPublished.text = data?.published ?: "-"
        detailIsbn.text = data?.isbn ?: "-"
        detailAsin.text = data?.asin ?: "-"
        detailLanguage.text = data?.language ?: "-"
        detailDescription.text = data?.sinopsis ?: "-"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}