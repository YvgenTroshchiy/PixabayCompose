package com.troshchii.pixabaycompose.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// TODO: Add full url for details
@Parcelize
data class Hit(
    val id: Int,
    val previewURL: String,
    val userImageURL: String,
    val user: String,
    val likes: Int,
) : Parcelable
