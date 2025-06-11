package com.andreemeilio.submissiondicodingandroidpemula.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AboutModel(
    var name: String,
    var email: String,
    var photo: Int
): Parcelable
