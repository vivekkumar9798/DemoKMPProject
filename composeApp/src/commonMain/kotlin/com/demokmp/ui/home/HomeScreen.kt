package com.demokmp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.demokmp.Dimens
import com.demokmp.ui.home.components.BottomNav
import com.demokmp.ui.home.components.TopBar
import com.demokmp.ui.home.content.ForYouScreen
import com.demokmp.ui.home.content.HomeContent
import com.demokmp.ui.home.content.LibraryScreen
import com.demokmp.ui.home.content.ProScreen
import com.demokmp.ui.home.content.SearchScreen
import com.demokmp.ui.home.model.NavItem

@Composable
fun TechVivHome() {
    var selectedNav by remember { mutableStateOf(NavItem.Home) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal))
                .padding(horizontal = Dimens.padding16, vertical = Dimens.padding12)
                .padding(bottom = Dimens.bottomNavHeight)
        ) {
            if (selectedNav == NavItem.Home) {
                TopBar()
                Spacer(Modifier.height(Dimens.padding12))
                Spacer(Modifier.height(Dimens.padding16))
            }
            when (selectedNav) {
                NavItem.Home -> HomeContent()
                NavItem.Search -> SearchScreen()
                NavItem.ForYou -> ForYouScreen()
                NavItem.Library -> LibraryScreen()
                NavItem.Pro -> ProScreen()
            }
        }

        BottomNav(
            selectedNav = selectedNav,
            onSelect = { selectedNav = it },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

