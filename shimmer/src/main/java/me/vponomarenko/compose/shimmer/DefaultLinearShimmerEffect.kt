package me.vponomarenko.compose.shimmer

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.core.graphics.transform
import kotlin.math.tan

object DefaultLinearShimmerEffectFactory : ShimmerEffectFactory {
    override fun create(
        baseAlpha: Float,
        highlightAlpha: Float,
        direction: ShimmerDirection,
        dropOff: Float,
        intensity: Float,
        tilt: Float
    ): ShimmerEffect {
        return DefaultLinearShimmerEffect(
            baseAlpha,
            highlightAlpha,
            direction,
            dropOff,
            intensity,
            tilt
        )
    }
}

private class DefaultLinearShimmerEffect(
    baseAlpha: Float,
    highlightAlpha: Float,
    val direction: ShimmerDirection,
    dropOff: Float,
    intensity: Float,
    val tilt: Float
) : ShimmerEffect {

    private var translateHeight = 0f
    private var translateWidth = 0f

    private var halfHeight = 0f
    private var halfWidth = 0f

    private val tiltTan = tan(Math.toRadians(tilt.toDouble())).toFloat()
    private val shaderColors = listOf(
        Color.Unspecified.copy(alpha = highlightAlpha),
        Color.Unspecified.copy(alpha = baseAlpha),
        Color.Unspecified.copy(alpha = highlightAlpha)
    )

    private val colorStops: List<Float> = listOf(
        ((1f - intensity - dropOff) / 2f).coerceIn(0f, 1f),
        ((1f - intensity - 0.001f) / 2f).coerceIn(0f, 1f),
        ((1f + intensity + dropOff) / 2f).coerceIn(0f, 1f)
    )

    private val paint = Paint().apply {
        isAntiAlias = true
        style = PaintingStyle.Fill
        blendMode = BlendMode.DstIn
    }

    override fun draw(canvas: Canvas, size: Size, progress: Float) {
        val (dx, dy) = direction.getOffset(translateWidth, translateHeight, progress)

        paint.shader?.transform {
            reset()
            postRotate(tilt, halfWidth, halfHeight)
            postTranslate(dx, dy)
        }

        canvas.drawRect(
            rect = Rect(0f, 0f, size.width, size.height),
            paint = paint
        )
    }


    override fun updateSize(size: Size) {
        translateHeight = size.height + tiltTan * size.width
        translateWidth = size.width + tiltTan * size.height

        halfHeight = size.height / 2f
        halfWidth = size.width / 2f

        paint.shader =
            LinearGradientShader(
                from = Offset(0f, 0f),
                to = direction.getToOffset(size.width, size.height),
                colors = shaderColors,
                colorStops = colorStops
            )
    }
}
