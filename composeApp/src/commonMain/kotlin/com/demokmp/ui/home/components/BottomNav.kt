package com.demokmp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.demokmp.AppColors
import com.demokmp.AppStrings
import com.demokmp.Dimens
import com.demokmp.ui.home.model.NavItem

@Composable
fun BottomNav(selectedNav: NavItem, onSelect: (NavItem) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(AppColors.backgroundLight)
            .padding(vertical = Dimens.bottomNavPadding)
            .windowInsetsPadding(
                (WindowInsets.safeDrawing).only(WindowInsetsSides.Bottom)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(
            label = AppStrings.NAV_HOME,
            emoji = "🏠",
            selected = selectedNav == NavItem.Home
        ) { onSelect(NavItem.Home) }
        BottomNavItem(
            label = AppStrings.NAV_SEARCH,
            emoji = "🔍",
            selected = selectedNav == NavItem.Search
        ) { onSelect(NavItem.Search) }
        BottomNavItem(
            label = AppStrings.NAV_FOR_YOU,
            emoji = "❤️",
            selected = selectedNav == NavItem.ForYou
        ) { onSelect(NavItem.ForYou) }
        BottomNavItem(
            label = AppStrings.NAV_LIBRARY,
            emoji = "📚",
            selected = selectedNav == NavItem.Library
        ) { onSelect(NavItem.Library) }
        BottomNavItem(
            label = AppStrings.NAV_PRO,
            emoji = "👑",
            selected = selectedNav == NavItem.Pro
        ) { onSelect(NavItem.Pro) }
    }
}

@Composable
private fun RowScope.BottomNavItem(
    label: String,
    emoji: String,
    selected: Boolean = false,
    onClick: () -> Unit
) {
    val color = if (selected) AppColors.primaryGreen else AppColors.textSecondary
    val emojiSize = if (selected) 24.sp else 22.sp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .weight(1f)
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = MutableInteractionSource()
            )
    ) {
        Text(
            text = emoji,
            fontSize = emojiSize,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            text = label,
            color = color,
            fontSize = Dimens.fontSize12,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}