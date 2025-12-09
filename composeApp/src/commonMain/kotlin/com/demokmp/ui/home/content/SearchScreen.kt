package com.demokmp.ui.home.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.times
import com.demokmp.AppColors
import com.demokmp.AppStrings
import com.demokmp.Dimens
import com.demokmp.ui.home.models.TrendingSearch
import com.demokmp.ui.home.models.BrowseCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    var searchText by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }

    val trendingSearches = listOf(
        TrendingSearch("Kesariya", "Brahmastra"),
        TrendingSearch("Apna Bana Le", "Bhediya"),
        TrendingSearch("Chaleya", "Jawan"),
        TrendingSearch("Tere Vaaste", "Zara Hatke Zara Bachke"),
        TrendingSearch("Satranga", "Animal")
    )

    val browseCategories = listOf(
        BrowseCategory(AppStrings.CATEGORY_TRENDING_NOW, AppColors.categoryPink),
        BrowseCategory(AppStrings.CATEGORY_HINDI, AppColors.categoryPurple),
        BrowseCategory(AppStrings.CATEGORY_ENGLISH, AppColors.categoryBlue),
        BrowseCategory(AppStrings.CATEGORY_PUNJABI, AppColors.categoryGreen),
        BrowseCategory(AppStrings.CATEGORY_TAMIL, AppColors.categoryOrange),
        BrowseCategory(AppStrings.CATEGORY_TELUGU, AppColors.categoryRed),
        BrowseCategory(AppStrings.CATEGORY_BOLLYWOOD, AppColors.categoryCyan),
        BrowseCategory(AppStrings.CATEGORY_ROMANCE, AppColors.categoryPink),
        BrowseCategory(AppStrings.CATEGORY_PARTY, AppColors.categoryDeepOrange),
        BrowseCategory(AppStrings.CATEGORY_DEVOTIONAL, AppColors.categoryOrange),
        BrowseCategory(AppStrings.CATEGORY_WORKOUT, AppColors.categoryGreen),
        BrowseCategory(AppStrings.CATEGORY_RETRO, AppColors.categoryPurple)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.whiteColor)
    ) {
        // Search Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.padding16)
                .height(Dimens.size56)
                .clip(RoundedCornerShape(Dimens.cornerRadius28))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(horizontal = Dimens.padding16),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Search Icon
            Text(
                text = "🔍",
                style = MaterialTheme.typography.titleMedium
            )

            BasicTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    isSearchActive = it.isNotEmpty()
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = Dimens.padding12),
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onSurface
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (searchText.isEmpty()) {
                        Text(
                            AppStrings.SEARCH_PLACEHOLDER,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    innerTextField()
                }
            )

            if (searchText.isNotEmpty()) {
                Text(
                    text = "✕",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.clickable {
                        searchText = ""
                        isSearchActive = false
                    }
                )
            }
        }

        // Content based on search state
        if (isSearchActive) {
            // Show search results placeholder
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.padding16),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🎵",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Spacer(modifier = Modifier.height(Dimens.padding16))
                    Text(
                        text = "${AppStrings.SEARCHING_FOR} \"$searchText\"...",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            // Show trending and browse all
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(Dimens.padding16)
            ) {
                // Trending Searches Section
                item {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                            initialOffsetY = { -it / 2 },
                            animationSpec = tween(300, easing = FastOutSlowInEasing)
                        )
                    ) {
                        Text(
                            text = AppStrings.TRENDING_SEARCHES,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.padding(bottom = Dimens.padding12)
                        )
                    }
                }

                itemsIndexed(trendingSearches) { index, search ->
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 400,
                                delayMillis = index * 50,
                                easing = FastOutSlowInEasing
                            )
                        ) + slideInHorizontally(
                            initialOffsetX = { it / 2 },
                            animationSpec = tween(
                                durationMillis = 400,
                                delayMillis = index * 50,
                                easing = FastOutSlowInEasing
                            )
                        )
                    ) {
                        TrendingSearchItem(search)
                    }
                }

                // Browse All Section
                item {
                    Spacer(modifier = Modifier.height(Dimens.padding24))
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(animationSpec = tween(300)) + slideInVertically(
                            initialOffsetY = { -it / 2 },
                            animationSpec = tween(300, easing = FastOutSlowInEasing)
                        )
                    ) {
                        Text(
                            text = AppStrings.BROWSE_ALL,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.padding(bottom = Dimens.padding12)
                        )
                    }
                }

                item {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(Dimens.spacing12),
                        verticalArrangement = Arrangement.spacedBy(Dimens.spacing12),
                        modifier = Modifier.height((browseCategories.size / 2 * Dimens.size100)),
                        userScrollEnabled = false
                    ) {
                        items(browseCategories) { category ->
                            BrowseCategoryCard(category)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TrendingSearchItem(search: TrendingSearch) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(vertical = Dimens.padding12),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "📈",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.width(Dimens.padding16))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = search.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = search.subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun BrowseCategoryCard(category: BrowseCategory) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.size80)
            .clip(RoundedCornerShape(Dimens.cornerRadius12))
            .background(category.color)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category.name,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(Dimens.padding16)
        )
    }
}