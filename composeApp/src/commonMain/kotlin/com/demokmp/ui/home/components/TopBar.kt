package com.demokmp.ui.home.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.demokmp.AppColors
import com.demokmp.AppStrings
import com.demokmp.Dimens

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(Dimens.spacing10)) {
            Box(
                modifier = Modifier
                    .size(Dimens.size36)
                    .clip(CircleShape)
                    .background(AppColors.primaryGreen),
                contentAlignment = Alignment.Center
            ) {
                Text("T", color = Color.White, fontWeight = FontWeight.Bold)
            }
            Column {
                Text(AppStrings.APP_NAME, style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
            }
        }
        Button(
            onClick = { /* settings */ },
            colors = ButtonDefaults.buttonColors(containerColor = AppColors.surfaceLight, contentColor = AppColors.textPrimary),
            shape = RoundedCornerShape(Dimens.cornerRadius16),
            contentPadding = ButtonDefaults.ContentPadding
        ) {
            Text("⚙︎", fontSize = Dimens.fontSize16)
        }
    }
}

@Composable
private fun Badge(label: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(Dimens.cornerRadius12))
            .background(AppColors.surfaceLight)
            .padding(horizontal = Dimens.spacing10, vertical = Dimens.padding4)
    ) {
        Text(label, color = AppColors.textPrimary, fontSize = Dimens.fontSize12, fontWeight = FontWeight.Medium)
    }
}

