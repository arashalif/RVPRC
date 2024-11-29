package com.arashaghelifar.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.arashaghelifar.repository.model.ResultState
import com.arashaghelifar.ui.components.RVTopBar
import com.arashaghelifar.ui.theme.Primary

@Composable
fun ContentScreen(
    content: ResultState<ContentUiState>
) {

    when (content) {
        is ResultState.Error -> {}
        ResultState.Loading -> Content(ContentUiState()) {}
        is ResultState.Success -> {
            if (content.data != null) {
                Content(content.data!!) {}
            }
        }
    }
}

@Composable
private fun Content(
    data: ContentUiState,
    onMenuClicked: () -> Unit
) {

    Scaffold(
        topBar = {
            RVTopBar(
                leftComponent = {
                    Spacer(modifier = Modifier.width(22.dp))
                },
                centerComponent = {
                    Text(
                        "Video",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                },
                rightComponent = {
                    Image(
                        painter = painterResource(id = R.drawable.more_horiz),
                        contentDescription = "More",
                        modifier = Modifier
                            .size(22.dp)
                            .clickable { onMenuClicked() }
                    )
                }
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                ContentBody(
                    data = data
                )
            }
        }
    )
}

@Composable
fun ContentBody(
    data: ContentUiState,
) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            data.dateString,
            style = MaterialTheme.typography.headlineSmall,
            color = Primary
        )

        Spacer(modifier = Modifier.height(8.dp))


        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            VideoPlayerWithThumbnail(
                videoUrl = data.videoUrl,
                thumbnailUrl = data.thumbnailUrl
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.svg_video),
                contentDescription = "Video Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                data.title, style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.svg_time),
                contentDescription = "Time Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                data.timeString, style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = painterResource(R.drawable.svg_badge_ai),
                contentDescription = "ai badge Icon",
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                "This video will be posted on",
                style = MaterialTheme.typography.bodySmall,
            )

            Spacer(modifier = Modifier.width(16.dp))

            data.platforms.forEach { d ->
                Image(
                    painter = painterResource(d.icon),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(6.dp))
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 11.dp)
        ) {
            Column {

                Text(
                    data.title,
                    style = MaterialTheme.typography.headlineSmall,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    data.description,
                    style = MaterialTheme.typography.displaySmall,
                )

            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .border(1.dp, Color(0xFFD0D5DD), shape = RoundedCornerShape(6.dp))
                .clip(shape = RoundedCornerShape(6.dp))
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {

            Row {
                Spacer(Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.svg_record),
                    contentDescription = "Time Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    "Record personal intro",
                    style = MaterialTheme.typography.labelMedium,
                )
                Spacer(Modifier.weight(1f))
            }

        }
    }
}

@Composable
fun VideoPlayerWithThumbnail(videoUrl: String, thumbnailUrl: String) {
    var isPlaying by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        if (isPlaying) {
            // Video Player
            AndroidView(
                factory = { context ->
                    val playerView = PlayerView(context).apply {
                        val exoPlayer = ExoPlayer.Builder(context).build().apply {
                            val mediaItem = MediaItem.fromUri(videoUrl)
                            setMediaItem(mediaItem)
                            prepare()
                            playWhenReady = true
                        }
                        this.player = exoPlayer
                    }
                    playerView
                },
                modifier = Modifier.fillMaxSize()
            )
        } else {
            // Thumbnail with Play Button

            AsyncImage(
                model = thumbnailUrl,
                contentDescription = "Video Thumbnail",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { isPlaying = true },
                contentScale =  ContentScale.Fit
            )

            Image(
                painter = painterResource(id = R.drawable.svg_play),
                contentDescription = "Play Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(36.dp)
            )
        }
    }
}

