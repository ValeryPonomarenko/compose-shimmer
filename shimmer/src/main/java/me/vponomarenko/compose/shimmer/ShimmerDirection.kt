package me.vponomarenko.compose.shimmer

import androidx.compose.ui.geometry.Offset

sealed class ShimmerDirection {

    internal abstract fun getOffset(
        translateWidth: Float,
        translateHeight: Float,
        progress: Float
    ): Pair<Float, Float>

    internal abstract fun getToOffset(width: Float, height: Float): Offset

    protected fun offset(start: Float, end: Float, percent: Float): Float {
        return start + (end - start) * percent
    }

    object LeftToRight : ShimmerDirection() {

        override fun getOffset(
            translateWidth: Float,
            translateHeight: Float,
            progress: Float
        ): Pair<Float, Float> =
            Pair(offset(-translateWidth, translateWidth, progress), 0f)

        override fun getToOffset(width: Float, height: Float): Offset =
            Offset(width, 0f)
    }

    object TopToBottom : ShimmerDirection() {

        override fun getOffset(
            translateWidth: Float,
            translateHeight: Float,
            progress: Float
        ): Pair<Float, Float> =
            Pair(0f, offset(-translateHeight, translateHeight, progress))

        override fun getToOffset(width: Float, height: Float): Offset =
            Offset(0f, height)
    }

    object RightToLeft : ShimmerDirection() {

        override fun getOffset(
            translateWidth: Float,
            translateHeight: Float,
            progress: Float
        ): Pair<Float, Float> =
            Pair(offset(translateWidth, -translateWidth, progress), 0f)

        override fun getToOffset(width: Float, height: Float): Offset =
            Offset(width, 0f)
    }

    object BottomToTop : ShimmerDirection() {

        override fun getOffset(
            translateWidth: Float,
            translateHeight: Float,
            progress: Float
        ): Pair<Float, Float> =
            Pair(0f, offset(translateHeight, -translateHeight, progress))

        override fun getToOffset(width: Float, height: Float): Offset =
            Offset(0f, height)
    }
}