package com.project.postapp.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.project.postapp.android.ui.components.MovieDetailComponent
import com.project.postapp.presentation.feature.psotlist.PostListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun PostScreen(viewModel: PostListViewModel = getViewModel()) {
    val postAsync by viewModel.uiState.collectAsState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding(),
    ) {
        val modifier = Modifier.padding(it)

        if (postAsync.isLoading) {
            LoadingScreen(modifier)
        } else if (postAsync.error != null) {
            ErrorScreen(modifier) {
                viewModel.loadPosts()
            }
        } else {
            MovieDetailComponent(posts = postAsync.posts)
        }

    }
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier, onTryAgain: () -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = ":(",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Black,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = "Cannot proceed your request, please try again!"
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(onClick = onTryAgain) {
            Text(text = "Try again")
        }
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = "Loading ...."
        )
    }

}
