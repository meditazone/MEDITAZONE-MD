package com.waekaizo.meditazone.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val icon: Painter,
    val screen: Screen
)
