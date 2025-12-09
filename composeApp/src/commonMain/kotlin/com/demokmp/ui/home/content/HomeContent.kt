package com.demokmp.ui.home.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.demokmp.AppColors
import com.demokmp.AppStrings
import com.demokmp.Dimens
import com.demokmp.ui.home.models.MusicItem


@Composable
fun HomeContent() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(animationSpec = tween(400)) + slideInVertically(
                initialOffsetY = { -it },
                animationSpec = tween(400, easing = FastOutSlowInEasing)
            ) + scaleIn(
                initialScale = 0.9f,
                animationSpec = tween(400, easing = FastOutSlowInEasing)
            )
        ) {
            HeroBanner()
        }
        Spacer(Modifier.height(Dimens.padding16))
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(animationSpec = tween(400, delayMillis = 100)) + slideInVertically(
                initialOffsetY = { it / 2 },
                animationSpec = tween(400, delayMillis = 100, easing = FastOutSlowInEasing)
            )
        ) {
            HorizontalSection(title = AppStrings.RECENTLY_PLAYED, items = recentlyPlayed)
        }
        Spacer(Modifier.height(Dimens.padding16))
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(animationSpec = tween(400, delayMillis = 200)) + slideInVertically(
                initialOffsetY = { it / 2 },
                animationSpec = tween(400, delayMillis = 200, easing = FastOutSlowInEasing)
            )
        ) {
            HorizontalSection(title = AppStrings.RECOMMENDED_ARTISTS, items = artistStations)
        }
        Spacer(Modifier.height(Dimens.padding16))
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(animationSpec = tween(400, delayMillis = 300)) + slideInVertically(
                initialOffsetY = { it / 2 },
                animationSpec = tween(400, delayMillis = 300, easing = FastOutSlowInEasing)
            )
        ) {
            SingleStationRow()
        }
        Spacer(Modifier.height(Dimens.padding20))
    }
}

@Composable
private fun HeroBanner() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.height180),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.height180)
                .background(
                    Brush.linearGradient(
                        colors = listOf(AppColors.backgroundDarkGradient, AppColors.backgroundDark)
                    )
                )
                .padding(Dimens.padding16)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().height(Dimens.height148)
            ) {
                Text(
                    AppStrings.PRO_LABEL,
                    style = MaterialTheme.typography.titleMedium.copy(color = AppColors.primaryGreenDark, fontWeight = FontWeight.Bold)
                )
                Text(
                    AppStrings.PRO_OFFER,
                    style = MaterialTheme.typography.headlineMedium.copy(color = Color.White, fontWeight = FontWeight.ExtraBold)
                )
                Button(
                    onClick = { /* CTA */ },
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.primaryGreen, contentColor = Color.White),
                    shape = RoundedCornerShape(Dimens.cornerRadius30)
                ) {
                    Text(AppStrings.CLAIM_NOW, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
private fun HorizontalSection(title: String, items: List<MusicItem>) {
    Column(verticalArrangement = Arrangement.spacedBy(Dimens.spacing10)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold))
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(Dimens.spacing12)) {
            itemsIndexed(items) { index, item ->
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
                    CoverCard(item)
                }
            }
        }
    }
}

@Composable
private fun CoverCard(item: MusicItem) {
    Card(
        modifier = Modifier.width(Dimens.width150),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(Dimens.cornerRadius14)
    ) {
        Row(modifier = Modifier.padding(Dimens.padding12), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(Dimens.size54)
                    .background(item.accentColor, shape = RoundedCornerShape(Dimens.cornerRadius12)),
                contentAlignment = Alignment.Center
            ) {
                Text(item.emoji, style = MaterialTheme.typography.titleMedium)
            }
            Spacer(Modifier.width(Dimens.width12))
            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium))
                Text(
                    item.subtitle,
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
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(Dimens.cornerRadius14)
    ) {
        Row(
            modifier = Modifier.padding(Dimens.padding14),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimens.spacing12)
        ) {
            Box(
                modifier = Modifier
                    .size(Dimens.size54)
                    .background(AppColors.accentLightBlue, shape = RoundedCornerShape(Dimens.cornerRadius12)),
                contentAlignment = Alignment.Center
            ) {
                Text("🎧", fontSize = Dimens.fontSize20)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text("Saiya Sewa Kare", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold))
                Text("Pawan Singh Radio", color = AppColors.textTertiary)
            }
            Text("▶", color = AppColors.primaryGreen, fontWeight = FontWeight.Bold)
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

