package me.vponomarenko.compose.shimmer

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas

interface ShimmerEffect {

    fun draw(canvas: Canvas, size: Size, progress: Float)

    fun updateSize(size: Size)
}

