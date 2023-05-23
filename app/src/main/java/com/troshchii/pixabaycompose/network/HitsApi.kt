package com.troshchii.pixabaycompose.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HitsApi {
    @GET(".") suspend fun getHits(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("image_type") imageType: String,
        @Query("safesearch") safeSearch: Boolean,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): Response<HitsResponse>
}
