package com.demokmp.ui.home.models

data class ProPlan(
    val name: String,
    val price: String,
    val duration: String,
    val savings: String?,
    val isPopular: Boolean = false
)
