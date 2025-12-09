package com.demokmp.ui.home.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demokmp.AppColors

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var darkMode by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "←",
                fontSize = 24.sp,
                modifier = Modifier
                    .clickable(onClick = onBackClick)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Settings",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Profile
            SettingCard(
                emoji = "👤",
                title = "Profile",
                subtitle = "View and edit your profile"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Notifications
            SettingCard(
                emoji = "🔔",
                title = "Notifications",
                subtitle = "Get notified about updates",
                showSwitch = true,
                switchState = notifications,
                onSwitchChange = { notifications = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Dark Mode
            SettingCard(
                emoji = "🌙",
                title = "Dark Mode",
                subtitle = "Easier on the eyes",
                showSwitch = true,
                switchState = darkMode,
                onSwitchChange = { darkMode = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Privacy
            SettingCard(
                emoji = "🔒",
                title = "Privacy Policy",
                showArrow = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Share
            SettingCard(
                emoji = "📤",
                title = "Share App",
                showArrow = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Version
            Text(
                text = "Version 1.0.0",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
private fun SettingCard(
    emoji: String,
    title: String,
    subtitle: String? = null,
    showSwitch: Boolean = false,
    switchState: Boolean = false,
    showArrow: Boolean = false,
    onSwitchChange: ((Boolean) -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick?.invoke() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF0F0F0)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = emoji, fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Text
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
                subtitle?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }

            // Switch or Arrow
            if (showSwitch) {
                Switch(
                    checked = switchState,
                    onCheckedChange = onSwitchChange,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = AppColors.primaryGreen,
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.LightGray
                    )
                )
            } else if (showArrow) {
                Text(text = "›", fontSize = 24.sp, color = Color.Gray)
            }
        }
    }
}