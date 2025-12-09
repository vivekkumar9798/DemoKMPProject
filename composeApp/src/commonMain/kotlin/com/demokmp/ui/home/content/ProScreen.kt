package com.demokmp.ui.home.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demokmp.AppColors
import com.demokmp.AppStrings
import com.demokmp.ui.home.models.ProPlan
import com.demokmp.ui.home.models.ProFeature

@Composable
fun ProScreen() {
    val listState = rememberLazyListState()
    
    val plans = listOf(
        ProPlan(AppStrings.PLAN_MINI, "₹99", AppStrings.DURATION_3_MONTHS, AppStrings.SAVE_17_PERCENT, false),
        ProPlan(AppStrings.PLAN_PRO, "₹399", AppStrings.DURATION_1_YEAR, AppStrings.SAVE_33_PERCENT, true),
        ProPlan(AppStrings.PLAN_MONTHLY, "₹99", AppStrings.DURATION_1_MONTH, null, false)
    )

    val features = listOf(
        ProFeature("🎵", AppStrings.FEATURE_AD_FREE, AppStrings.FEATURE_AD_FREE_DESC),
        ProFeature("⬇️", AppStrings.FEATURE_DOWNLOADS, AppStrings.FEATURE_DOWNLOADS_DESC),
        ProFeature("🎧", AppStrings.FEATURE_HIGH_QUALITY, AppStrings.FEATURE_HIGH_QUALITY_DESC),
        ProFeature("📱", AppStrings.FEATURE_MULTI_DEVICE, AppStrings.FEATURE_MULTI_DEVICE_DESC),
        ProFeature("🎤", AppStrings.FEATURE_LYRICS, AppStrings.FEATURE_LYRICS_DESC),
        ProFeature("🎼", AppStrings.FEATURE_PLAYLISTS, AppStrings.FEATURE_PLAYLISTS_DESC),
        ProFeature("⏭️", AppStrings.FEATURE_SKIPS, AppStrings.FEATURE_SKIPS_DESC),
        ProFeature("🌍", AppStrings.FEATURE_GLOBAL, AppStrings.FEATURE_GLOBAL_DESC)
    )

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.whiteColor),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        // Hero Section with Gradient
        item {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(500)) + slideInVertically(
                    initialOffsetY = { -it },
                    animationSpec = tween(500, easing = FastOutSlowInEasing)
                ) + scaleIn(
                    initialScale = 0.9f,
                    animationSpec = tween(500, easing = FastOutSlowInEasing)
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF6A1B9A),
                                    Color(0xFF8E24AA),
                                    Color(0xFFAB47BC)
                                )
                            )
                        )
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "👑",
                            fontSize = 72.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = AppStrings.PRO_SCREEN_TITLE,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = AppStrings.PRO_SCREEN_SUBTITLE,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Surface(
                            shape = RoundedCornerShape(24.dp),
                            color = Color.White
                        ) {
                            Text(
                                text = AppStrings.START_FREE_TRIAL,
                                modifier = Modifier.padding(horizontal = 32.dp, vertical = 12.dp),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6A1B9A)
                            )
                        }
                    }
                }
            }
        }

        // Plans Section
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = AppStrings.CHOOSE_YOUR_PLAN,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        itemsIndexed(plans) { index, plan ->
            PlanCard(plan = plan)
        }

        // Features Section
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = AppStrings.PRO_FEATURES,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        itemsIndexed(features) { index, feature ->
            FeatureItem(feature = feature)
        }

        // Footer
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = AppStrings.ALREADY_PRO_MEMBER,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = AppStrings.RESTORE_PURCHASE,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { }
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = AppStrings.TERMS_AND_PRIVACY,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PlanCard(plan: ProPlan) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        color = if (plan.isPopular)
            Color(0xFF6A1B9A).copy(alpha = 0.1f)
        else
            MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = if (plan.isPopular) 4.dp else 1.dp,
        border = if (plan.isPopular)
            androidx.compose.foundation.BorderStroke(2.dp, Color(0xFF6A1B9A))
        else null
    ) {
        Box(modifier = Modifier.clickable { }) {
            if (plan.isPopular) {
                Surface(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF6A1B9A)
                ) {
                    Text(
                        text = AppStrings.POPULAR_BADGE,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = plan.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = plan.duration,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (plan.savings != null) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = plan.savings,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4CAF50)
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = plan.price,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (plan.isPopular)
                            Color(0xFF6A1B9A)
                        else
                            MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = when {
                            plan.duration.contains("Year") -> AppStrings.PER_YEAR
                            plan.duration.contains("3") -> AppStrings.PER_3_MONTHS
                            else -> AppStrings.PER_MONTH
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun FeatureItem(feature: ProFeature) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF6A1B9A).copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = feature.icon,
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = feature.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 20.sp
            )
        }
    }
}