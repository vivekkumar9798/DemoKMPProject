package com.demokmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.demokmp.ui.TechVivTheme
import com.demokmp.ui.home.TechVivHome

@Composable
@Preview
fun App() {
    TechVivTheme {
        Surface(modifier = Modifier.fillMaxSize().systemBarsPadding(),
            color = AppColors.whiteColor,
        ) {
            TechVivHome()
        }
    }
}