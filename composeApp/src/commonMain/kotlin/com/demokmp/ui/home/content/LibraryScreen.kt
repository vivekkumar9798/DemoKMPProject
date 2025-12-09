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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demokmp.AppColors
import com.demokmp.AppStrings
import com.demokmp.ui.home.models.LibraryItem
import com.demokmp.ui.home.models.RecentSong
import com.demokmp.ui.home.models.PlaylistItem

@Composable
fun LibraryScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf(AppStrings.TAB_SONGS, AppStrings.TAB_PLAYLISTS, AppStrings.TAB_ALBUMS, AppStrings.TAB_ARTISTS)

    val quickAccessItems = listOf(
        LibraryItem(AppStrings.LIKED_SONGS, "124 songs", "❤️", Color(0xFFE91E63)),
        LibraryItem(AppStrings.DOWNLOADS, "45 songs", "⬇️", Color(0xFF4CAF50)),
        LibraryItem(AppStrings.HISTORY, "200+ songs", "🕒", Color(0xFF2196F3)),
        LibraryItem(AppStrings.PODCASTS, "12 shows", "🎙️", Color(0xFF9C27B0))
    )

    val recentSongs = listOf(
        RecentSong("Kesariya", "Arijit Singh", "4:28", Color(0xFFE91E63)),
        RecentSong("Apna Bana Le", "Arijit Singh", "3:54", Color(0xFF9C27B0)),
        RecentSong("Chaleya", "Arijit Singh", "4:02", Color(0xFF2196F3)),
        RecentSong("Tere Vaaste", "Varun Jain", "3:48", Color(0xFF4CAF50)),
        RecentSong("Satranga", "Arijit Singh", "4:32", Color(0xFFFF9800)),
        RecentSong("Deva Deva", "Arijit Singh", "4:15", Color(0xFFF44336)),
        RecentSong("Raataan Lambiyan", "Jubin Nautiyal", "3:56", Color(0xFF00BCD4))
    )

    val playlists = listOf(
        PlaylistItem("My Favorites", "45 songs", Color(0xFFE91E63)),
        PlaylistItem("Workout Mix", "32 songs", Color(0xFF4CAF50)),
        PlaylistItem("Chill Vibes", "28 songs", Color(0xFF2196F3)),
        PlaylistItem("Party Hits", "56 songs", Color(0xFFFF5722))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.whiteColor)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = AppStrings.MY_LIBRARY,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            // Quick Access Section
            item {
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    itemsIndexed(quickAccessItems) { index, item ->
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn(
                                animationSpec = tween(
                                    durationMillis = 400,
                                    delayMillis = index * 80,
                                    easing = FastOutSlowInEasing
                                )
                            ) + slideInHorizontally(
                                initialOffsetX = { it },
                                animationSpec = tween(
                                    durationMillis = 400,
                                    delayMillis = index * 80,
                                    easing = FastOutSlowInEasing
                                )
                            ) + scaleIn(
                                initialScale = 0.8f,
                                animationSpec = tween(
                                    durationMillis = 400,
                                    delayMillis = index * 80,
                                    easing = FastOutSlowInEasing
                                )
                            )
                        ) {
                            QuickAccessCard(item)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }

            // Tabs
            item {
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    modifier = Modifier.fillMaxWidth(),
                    edgePadding = 16.dp,
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.primary,
                    indicator = { },
                    divider = { }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(20.dp),
                                color = if (selectedTab == index)
                                    MaterialTheme.colorScheme.primaryContainer
                                else
                                    Color.Transparent,
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                Text(
                                    text = title,
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal,
                                    color = if (selectedTab == index)
                                        MaterialTheme.colorScheme.onPrimaryContainer
                                    else
                                        MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Content based on selected tab
            when (selectedTab) {
                0 -> { // Songs
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${recentSongs.size} Songs",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = AppStrings.SORT_BY,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                                Text(
                                    text = "⇅",
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                    itemsIndexed(recentSongs) { index, song ->
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn(
                                animationSpec = tween(
                                    durationMillis = 300,
                                    delayMillis = index * 50,
                                    easing = FastOutSlowInEasing
                                )
                            ) + slideInVertically(
                                initialOffsetY = { it / 2 },
                                animationSpec = tween(
                                    durationMillis = 300,
                                    delayMillis = index * 50,
                                    easing = FastOutSlowInEasing
                                )
                            )
                        ) {
                            SongListItem(song)
                        }
                    }
                }
                1 -> { // Playlists
                    itemsIndexed(playlists) { index, playlist ->
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn(
                                animationSpec = tween(
                                    durationMillis = 300,
                                    delayMillis = index * 50,
                                    easing = FastOutSlowInEasing
                                )
                            ) + slideInVertically(
                                initialOffsetY = { it / 2 },
                                animationSpec = tween(
                                    durationMillis = 300,
                                    delayMillis = index * 50,
                                    easing = FastOutSlowInEasing
                                )
                            )
                        ) {
                            PlaylistListItem(playlist)
                        }
                    }
                }
                2 -> { // Albums
                    item {
                        EmptyStateView(
                            icon = "💿",
                            title = AppStrings.NO_ALBUMS_YET,
                            subtitle = AppStrings.NO_ALBUMS_SUBTITLE
                        )
                    }
                }
                3 -> { // Artists
                    item {
                        EmptyStateView(
                            icon = "🎤",
                            title = AppStrings.NO_ARTISTS_YET,
                            subtitle = AppStrings.NO_ARTISTS_SUBTITLE
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuickAccessCard(item: LibraryItem) {
    Surface(
        modifier = Modifier
            .width(160.dp)
            .height(80.dp),
        shape = RoundedCornerShape(12.dp),
        color = item.color.copy(alpha = 0.15f),
        tonalElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable { }
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(item.color),
                contentAlignment = Alignment.Center
            ) {
                Text(text = item.icon, fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1
                )
                Text(
                    text = item.count,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
fun SongListItem(song: RecentSong) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(song.color),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "♪", fontSize = 28.sp, color = Color.White.copy(alpha = 0.6f))
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = song.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1
            )
            Text(
                text = song.artist,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }

        Text(
            text = song.duration,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(end = 8.dp)
        )

        Text(
            text = "⋮",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.clickable { }
        )
    }
}

@Composable
fun PlaylistListItem(playlist: PlaylistItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(playlist.color),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "📝", fontSize = 28.sp)
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = playlist.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1
            )
            Text(
                text = playlist.songCount,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }

        Text(
            text = "→",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun EmptyStateView(icon: String, title: String, subtitle: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = icon, fontSize = 64.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}