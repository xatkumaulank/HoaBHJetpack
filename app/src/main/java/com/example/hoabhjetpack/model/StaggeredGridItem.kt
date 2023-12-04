package com.example.hoabhjetpack.component

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

data class StaggeredGridItem(
    val icon: Int,
    val title: String,
    val content: String,
    val height: Int,
    val brush: Brush,
    val widthIcon: Dp,
    val heightIcon: Dp,
    val colorText: Color
)



