package com.troshchii.pixabaycompose.ui.hitlist

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.troshchii.pixabaycompose.data.Hit

@Composable
fun HitList(
    viewModel: MainViewModel = viewModel()
) {
    val hits: List<Hit> by viewModel.hits.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
    ) {
        items(hits) { HitListItem(it) }
    }
}

@Composable
fun HitListItem(hit: Hit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = hit.previewURL,
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )
        Text(text = hit.user)
    }
}
