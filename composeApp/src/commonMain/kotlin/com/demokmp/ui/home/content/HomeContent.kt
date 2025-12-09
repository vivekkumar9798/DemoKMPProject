package com.demokmp.ui.home.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demokmp.AppColors
import com.demokmp.AppStrings
import com.demokmp.ui.home.models.MusicItem

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HeroBanner()
        Spacer(Modifier.height(24.dp))
        HorizontalSection(
            title = AppStrings.RECENTLY_PLAYED,
            items = recentlyPlayed
        )

        Spacer(Modifier.height(24.dp))

        HorizontalSection(
            title = AppStrings.RECOMMENDED_ARTISTS,
            items = artistStations
        )

        Spacer(Modifier.height(24.dp))

        SingleStationRow()

        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun HeroBanner() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            AppColors.backgroundDarkGradient,
                            AppColors.backgroundDark
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = AppStrings.PRO_LABEL,
                    style = MaterialTheme.typography.titleMedium,
                    color = AppColors.primaryGreenDark,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = AppStrings.PRO_OFFER,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.primaryGreen,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text(
                        text = AppStrings.CLAIM_NOW,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun HorizontalSection(
    title: String,
    items: List<MusicItem>
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items) { item ->
                MusicCard(item)
            }
        }
    }
}

@Composable
private fun MusicCard(item: MusicItem) {
    Card(
        modifier = Modifier.width(200.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .background(
                        color = item.accentColor,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item.emoji,
                    fontSize = 24.sp
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppColors.textLight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun SingleStationRow() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .background(
                        color = AppColors.accentLightBlue,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🎧", fontSize = 24.sp)
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Saiya Sewa Kare",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Pawan Singh Radio",
                    color = AppColors.textTertiary,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = "▶",
                color = AppColors.primaryGreen,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

private val recentlyPlayed = listOf(
    MusicItem("Flirty MIX", "Pawan Singh", "🎵", AppColors.accentOrange),
    MusicItem("Ye Kareja Kaha", "Nirahua, S. Singh", "🎬", AppColors.accentBlue),
    MusicItem("Item Number MIX", "Pawan Singh, Indi...", "🎉", AppColors.accentPurple),
    MusicItem("Bhojpuri Hits", "Various Artists", "💿", AppColors.accentPink)
)

private val artistStations = listOf(
    MusicItem("Saiya Sewa Kare", "Pawan Singh Radio", "🎧", AppColors.accentLightBlue),
    MusicItem("Top Artist Mix", "Your favorites", "⭐", AppColors.accentGreen),
    MusicItem("Indie Radar", "Fresh finds", "🎸", AppColors.accentGray)
)