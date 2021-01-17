package com.delbel.droid.chart.line.painter.series.marker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.Style.FILL
import androidx.core.content.ContextCompat
import com.delbel.droid.chart.line.R
import com.delbel.droid.chart.line.painter.series.CanvasSeriesPainter
import com.delbel.droid.chart.line.spec.Chart
import com.delbel.droid.chart.line.spec.Markers
import com.delbel.droid.chart.line.spec.series.marker.Circle

class CirclePainter(
    private val context: Context,
    private val coordinates: Markers,
    private val circle: Circle
) : CanvasSeriesPainter {

    private val radius = context.resources.getDimension(R.dimen.line_chart_circle_marker_radius)

    private var fillPaint = Paint().apply {
        color = ContextCompat.getColor(context, circle.color)
        style = FILL
        isAntiAlias = true
    }

    override fun draw(canvas: Canvas, chart: Chart) = coordinates
        .coordinates(canvas, chart.highestY)
        .forEach { coordinate -> canvas.drawCircle(coordinate.x, coordinate.y, radius, fillPaint) }
}
