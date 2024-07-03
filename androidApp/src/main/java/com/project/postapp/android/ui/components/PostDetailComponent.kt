package com.project.postapp.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.project.postapp.domain.entity.Post


@Composable
fun MovieDetailComponent(posts: List<Post>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(posts) { post ->
            PostCell(post = post)
        }
    }

}

@Composable
fun PostCell(post: Post) {
    Column {
        Text(
            text = post.title,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 4.dp)
                ,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            text = post.body,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                ,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Left,
        )
    }
}