package me.vponomarenko.compose.shimmer

import androidx.compose.animation.core.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.withSaveLayer
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints

fun Modifier.shimmer(
    durationMs: Int = 1500,
    shimmerTheme: ShimmerTheme = ShimmerTheme.DEFAULT
): Modifier = composed {
    var highlightProgress: Float by remember { mutableStateOf(0f) }
    val infiniteTransition = rememberInfiniteTransition()

    highlightProgress = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMs,
                easing = LinearEasing
            ),
            repeatMode = androidx.compose.animation.core.RepeatMode.Restart
        )
    ).value

    val paint = remember { Paint() }
    val shimmer = remember {
        shimmerTheme.run {
            shimmerEffectFactory.create(
                baseAlpha = alphaOfUnhighlitedArea,
                tilt = tiltInDegree,
                dropOff = dropOff,
                intensity = intensity,
                highlightAlpha = alphaOfHighlightedArea,
                direction = direction
            )
        }
    }

    return@composed ShimmerModifier(
        shimmer = shimmer,
        progress = highlightProgress,
        paint = paint
    )
}

private class ShimmerModifier(
    val shimmer: ShimmerEffect,
    val progress: Float,
    val paint: Paint
) : DrawModifier, LayoutModifier {

    private var size = Size(0f, 0f)

    override fun ContentDrawScope.draw() {
        drawIntoCanvas { canvas ->
            canvas.withSaveLayer(
                Rect(
                    0f,
                    0f,
                    this@ShimmerModifier.size.width,
                    this@ShimmerModifier.size.height
                ),
                paint
            ) {
                drawContent()
                shimmer.draw(
                    canvas,
                    this@ShimmerModifier.size,
                    progress
                )
            }
        }
    }


    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val placeable = measurable.measure(constraints)
        size = Size(width = placeable.width.toFloat(), height = placeable.height.toFloat())
        shimmer.updateSize(size)
        return layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}
