package com.demokmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.demokmp.ui.TecorbTheme
import com.demokmp.ui.home.TecorbHome

@Composable
@Preview
fun App() {
    TecorbTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            TecorbHome()
        }
    }
}