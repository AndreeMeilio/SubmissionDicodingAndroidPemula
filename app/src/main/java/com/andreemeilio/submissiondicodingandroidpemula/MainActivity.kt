package com.andreemeilio.submissiondicodingandroidpemula

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.andreemeilio.submissiondicodingandroidpemula.adapter.ListBookAdapter
import com.andreemeilio.submissiondicodingandroidpemula.databinding.ActivityMainBinding
import com.andreemeilio.submissiondicodingandroidpemula.model.BookModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewBooks: RecyclerView
    private lateinit var listBooks: ArrayList<BookModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(findViewById(R.id.activityActionBar))


        listBooks = arrayListOf()
        recyclerViewBooks = findViewById(R.id.rv_books)

        val listJudul = resources.getStringArray(R.array.judul)
        val listPenulis = resources.getStringArray(R.array.penulis)
        val listSinopis = resources.getStringArray(R.array.sinopsis)
        val listCover = resources.getStringArray(R.array.cover)
        val listRating = resources.getIntArray(R.array.rating)
        val listGenres = resources.getStringArray(R.array.genres)
        val listFormat = resources.getStringArray(R.array.format)
        val listPublished = resources.getStringArray(R.array.published)
        val listIsbn = resources.getStringArray(R.array.isbn)
        val listAsin = resources.getStringArray(R.array.asin)
        val listLanguage = resources.getStringArray(R.array.language)

        for (index in 0..(listJudul.size - 1)){
            val listGenresFormated = listGenres[index].split(',')

            val dataBook: BookModel = BookModel(
                judul = listJudul[index],
                penulis = listPenulis[index],
                sinopsis = listSinopis[index],
                cover = listCover[index],
                rating = listRating[index],
                genres = ArrayList<String>(listGenresFormated),
                format = listFormat[index],
                published = listPublished[index],
                isbn = listIsbn[index],
                asin = listAsin[index],
                language = listLanguage[index]
            )

            listBooks.add(dataBook)
        }

        recyclerViewBooks.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerViewBooks.adapter = ListBookAdapter(listBooks, object : ListBookAdapter.ListItemOnClick{
            override fun onClick(position: Int): View.OnClickListener {
                return View.OnClickListener {
                    val detailIntent: Intent = Intent(this@MainActivity, DetailActivity::class.java)
                    detailIntent.putExtra(DetailActivity.BOOK_EXTRA, listBooks[position])
                    startActivity(detailIntent)
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.aboutButton -> {
                var moveToAbout: Intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveToAbout)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}