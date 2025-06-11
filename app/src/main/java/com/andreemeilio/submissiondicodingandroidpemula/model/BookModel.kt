package com.andreemeilio.submissiondicodingandroidpemula.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookModel(
    var judul: String = "",
    var penulis: String = "",
    var sinopsis: String = "",
    var cover: String = "",
    var rating: Int = 0,
    var genres: ArrayList<String> = arrayListOf(),
    var format: String = "",
    var published: String = "",
    var isbn: String = "",
    var asin: String = "",
    var language: String = ""
): Parcelable
