package com.troshchii.pixabaycompose.ui.hitlist

import com.troshchii.pixabaycompose.data.Hit
import com.troshchii.pixabaycompose.data.HitsPagingSource
import com.troshchii.pixabaycompose.network.HitsApi
import com.troshchii.pixabaycompose.network.toUi
import javax.inject.Inject
import javax.inject.Named

interface HitsRepository {
    //    fun load(): Flow<PagingData<Hit>>
    suspend fun loadHits(): List<Hit>
}

class HitsRepositoryImpl @Inject constructor(
    @Named("ApiKey") private val apiKey: String,
    private val service: HitsApi,
    private val pagingSource: HitsPagingSource
) : HitsRepository {

    override suspend fun loadHits(): List<Hit> {
        val result = service.getHits(
            key = apiKey,
            q = "yellow+flowers",
            imageType = "photo",
            safeSearch = true,
            page = 1,
            perPage = 10
        )

        val body = result.body()

//        return if (result.isSuccessful && body != null) {
//            val hits: List<Hit> = body.toUi()
//        } else {
//
//        }

        return body?.toUi() ?: emptyList()
    }

//    override fun load(): Flow<PagingData<Hit>> = Pager(
//        config = PagingConfig(pageSize = HitsPagingSource.PAGE_SIZE),
//        pagingSourceFactory = { pagingSource }
//    ).flow
}
