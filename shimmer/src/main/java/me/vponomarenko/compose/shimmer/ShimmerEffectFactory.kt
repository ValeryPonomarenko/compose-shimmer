package me.vponomarenko.compose.shimmer

interface ShimmerEffectFactory {

    fun create(
        baseAlpha: Float,
        highlightAlpha: Float,
        direction: ShimmerDirection,
        dropOff: Float,
        intensity: Float,
        tilt: Float
    ): ShimmerEffect
}
