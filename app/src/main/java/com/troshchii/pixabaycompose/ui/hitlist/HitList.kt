package com.troshchii.pixabaycompose.ui.hitlist

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.troshchii.pixabaycompose.data.Hit
import com.troshchii.pixabaycompose.ui.theme.PixabayComposeTheme

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
            placeholder = debugPlaceholder(androidx.core.R.drawable.notification_action_background),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )
        Text(text = hit.user)
    }
}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) =
    if (LocalInspectionMode.current) {
        painterResource(id = debugPreview)
    } else {
        null
    }

@Preview
@Composable
fun HitListPreview() {
    PixabayComposeTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            HitListItem(
                hit = Hit(
                    id = 8003723,
                    previewURL = "https://cdn.pixabay.com/photo/2023/05/19/05/33/boats-8003723_150.jpg",
                    userImageURL = "https://cdn.pixabay.com/user/2023/05/11/12-45-48-601_250x250.jpg",
                    user = "ri1yad",
                    likes = 62,
                )
            )
        }
    }
}
