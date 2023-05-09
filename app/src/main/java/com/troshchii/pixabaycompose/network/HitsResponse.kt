package com.troshchii.pixabaycompose.network

import com.troshchii.pixabaycompose.data.Hit

data class HitsResponse(
    val total: Int = 0,
    val totalHits: Int = 0,
    val hits: List<HitDto>,
)

data class HitDto(
    val id: Int,
    val previewURL: String,
    val userImageURL: String,
    val user: String,
    val likes: Int,
)

fun HitsResponse.toUi(): List<Hit> = hits.map { it.toUi() }

fun HitDto.toUi(): Hit {
    return Hit(
        id = id,
        previewURL = previewURL,
        userImageURL = userImageURL,
        user = user,
        likes = likes,
    )
}
