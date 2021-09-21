package me.vponomarenko.compose.shimmer

import androidx.annotation.FloatRange

data class ShimmerTheme(
    val shimmerEffectFactory: ShimmerEffectFactory,
    @FloatRange(from = 0.0, to = 1.0)
    val alphaOfUnhighlitedArea: Float,
    @FloatRange(from = 0.0, to = 1.0)
    val alphaOfHighlightedArea: Float,
    val direction: ShimmerDirection,
    @FloatRange(from = 0.0, to = 1.0)
    val dropOff: Float,
    @FloatRange(from = 0.0, to = 1.0)
    val intensity: Float,
    val tiltInDegree: Float
) {
    init {
        require(alphaOfUnhighlitedArea in 0f..1f) { "baseAlpha must be between 0f and 1f but it is $alphaOfUnhighlitedArea" }

        require(alphaOfHighlightedArea in 0f..1f) { "highlightAlpha must be between 0f and 1f but it is $alphaOfHighlightedArea" }

        require(dropOff in 0f..1f) { "dropOff must be between 0f and 1f but it is $dropOff" }

        require(intensity in 0f..1f) { "intensity must be between 0f and 1f but it is $intensity" }
    }

    companion object {
        val DEFAULT = ShimmerTheme(
            shimmerEffectFactory = DefaultLinearShimmerEffectFactory,
            alphaOfUnhighlitedArea = 0.1f,
            alphaOfHighlightedArea = 1f,
            direction = ShimmerDirection.LeftToRight,
            dropOff = 0.5f,
            intensity = 0f,
            tiltInDegree = 40f
        )
    }
}