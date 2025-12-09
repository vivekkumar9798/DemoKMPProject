package com.demokmp.ui.home.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demokmp.AppColors
import com.demokmp.AppStrings
import com.demokmp.ui.home.models.Song
import com.demokmp.ui.home.models.Playlist
import com.demokmp.ui.home.models.Album

@Composable
fun ForYouScreen() {
    val listState = rememberLazyListState()
    
    val topPicks = listOf(
        Song("Kesariya", "Arijit Singh", Color(0xFFE91E63)),
        Song("Apna Bana Le", "Arijit Singh", Color(0xFF9C27B0)),
        Song("Chaleya", "Arijit Singh", Color(0xFF2196F3)),
        Song("Tere Vaaste", "Varun Jain", Color(0xFF4CAF50)),
        Song("Satranga", "Arijit Singh", Color(0xFFFF9800))
    )

    val recentlyPlayed = listOf(
        Song("Deva Deva", "Arijit Singh", Color(0xFFF44336)),
        Song("Raataan Lambiyan", "Jubin Nautiyal", Color(0xFF00BCD4)),
        Song("Heeriye", "Arijit Singh", Color(0xFFE91E63)),
        Song("Sajni", "Arijit Singh", Color(0xFF9C27B0))
    )

    val recommendedPlaylists = listOf(
        Playlist("Bollywood Romance", "50 songs", Color(0xFFE91E63)),
        Playlist("Late Night Vibes", "30 songs", Color(0xFF673AB7)),
        Playlist("Workout Motivation", "40 songs", Color(0xFF4CAF50)),
        Playlist("90s Classics", "100 songs", Color(0xFFFF9800))
    )

    val newReleases = listOf(
        Album("Animal", "Various Artists", Color(0xFFF44336)),
        Album("Jawan", "Anirudh", Color(0xFF9C27B0)),
        Album("Pathaan", "Vishal-Shekhar", Color(0xFF2196F3)),
        Album("Fighter", "Various Artists", Color(0xFFFF5722))
    )

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.whiteColor),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        // Header
        item {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(400)) + slideInVertically(
                    initialOffsetY = { -it },
                    animationSpec = tween(400, easing = FastOutSlowInEasing)
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF1E88E5),
                                    MaterialTheme.colorScheme.background
                                )
                            )
                        )
                        .padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = AppStrings.GOOD_EVENING,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = AppStrings.MUSIC_FOR_YOU,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }

        // Top Picks Section
        item {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                    initialOffsetY = { it / 2 },
                    animationSpec = tween(300, easing = FastOutSlowInEasing)
                )
            ) {
                SectionHeader(AppStrings.YOUR_TOP_PICKS)
            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(topPicks) { index, song ->
                    SongCard(song = song)
                }
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }

        // Recently Played Section
        item {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                    initialOffsetY = { it / 2 },
                    animationSpec = tween(300, easing = FastOutSlowInEasing)
                )
            ) {
                SectionHeader(AppStrings.RECENTLY_PLAYED)
            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(recentlyPlayed) { index, song ->
                    SongCard(song = song)
                }
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }

        // Recommended Playlists Section
        item {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                    initialOffsetY = { it / 2 },
                    animationSpec = tween(300, easing = FastOutSlowInEasing)
                )
            ) {
                SectionHeader(AppStrings.RECOMMENDED_PLAYLISTS)
            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(recommendedPlaylists) { index, playlist ->
                    PlaylistCard(playlist = playlist)
                }
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }

        // New Releases Section
        item {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                    initialOffsetY = { it / 2 },
                    animationSpec = tween(300, easing = FastOutSlowInEasing)
                )
            ) {
                SectionHeader(AppStrings.NEW_RELEASES)
            }
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(newReleases) { index, album ->
                    AlbumCard(album = album)
                }
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }
    }
}

@Composable
fun SectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = AppStrings.SEE_ALL,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { }
        )
    }
}

@Composable
fun SongCard(song: Song) {
    Column(
        modifier = Modifier.width(140.dp)
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(song.color)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "♪",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White.copy(alpha = 0.3f),
                fontSize = 60.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = song.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1
        )
        Text(
            text = song.artist,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
    }
}

@Composable
fun PlaylistCard(playlist: Playlist) {
    Column(
        modifier = Modifier.width(140.dp)
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            playlist.color,
                            playlist.color.copy(alpha = 0.6f)
                        )
                    )
                )
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "📝",
                style = MaterialTheme.typography.displayLarge,
                fontSize = 50.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = playlist.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 2
        )
        Text(
            text = playlist.subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
    }
}

@Composable
fun AlbumCard(album: Album) {
    Column(
        modifier = Modifier.width(140.dp)
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(album.color)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "💿",
                style = MaterialTheme.typography.displayLarge,
                fontSize = 50.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = album.name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1
        )
        Text(
            text = album.artist,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1
        )
    }
}