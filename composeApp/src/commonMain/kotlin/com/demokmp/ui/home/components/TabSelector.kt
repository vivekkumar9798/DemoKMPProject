package com.demokmp.ui.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import com.demokmp.AppColors
import com.demokmp.Dimens



@Composable
private fun TabChip(label: String, selected: Boolean, onClick: () -> Unit) {
    val bg = if (selected) MaterialTheme.colorScheme.primary else AppColors.backgroundLight
    val fg = if (selected) MaterialTheme.colorScheme.onPrimary else AppColors.textPrimary
    val borderColor = if (selected) Color.Transparent else AppColors.surfaceBorder

    Box(
        modifier = Modifier
            .graphicsLayer {
                shadowElevation = 0f
                clip = true
                shape = androidx.compose.foundation.shape.RoundedCornerShape(Dimens.cornerRadius20)
            }
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val cornerRadius = CornerRadius(Dimens.cornerRadius20.toPx())

            // Draw background
            drawRoundRect(
                color = bg,
                topLeft = Offset.Zero,
                size = size,
                cornerRadius = cornerRadius
            )

            // Draw border
            if (!selected) {
                drawRoundRect(
                    color = borderColor,
                    topLeft = Offset.Zero,
                    size = size,
                    cornerRadius = cornerRadius,
                    style = Stroke(width = Dimens.padding4.toPx())
                )
            }
        }

        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = fg,
            modifier = Modifier.padding(horizontal = Dimens.padding16, vertical = Dimens.spacing10)
        )
    }
}