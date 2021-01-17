package com.delbel.droid.chart.line.painter.series.marker

import android.content.Context
import android.graphics.*
import android.graphics.Paint.Style.FILL
import androidx.core.content.ContextCompat
import com.delbel.droid.chart.line.R
import com.delbel.droid.chart.line.painter.series.CanvasSeriesPainter
import com.delbel.droid.chart.line.spec.Chart
import com.delbel.droid.chart.line.spec.Markers
import com.delbel.droid.chart.line.spec.series.Coordinate
import com.delbel.droid.chart.line.spec.series.marker.Diamond

class DiamondPainter(
    private val context: Context,
    private val coordinates: Markers,
    private val diamond: Diamond
) : CanvasSeriesPainter {

    private val halfDiagonal = context.resources.getDimension(R.dimen.line_chart_diamond_marker_half_diagonal)

    private val path = Path()
    private var paint = Paint().apply {
        color = ContextCompat.getColor(context, diamond.color)
        style = FILL
        isAntiAlias = true
    }

    override fun draw(canvas: Canvas, chart: Chart) = coordinates
        .coordinates(canvas, chart.highestY)
        .forEach { coordinate -> canvas.drawMarker(position = coordinate) }

    private fun Canvas.drawMarker(position: Coordinate) {
        path.moveTo(position.x, position.y + halfDiagonal)

        path.lineTo(position.x - halfDiagonal, position.y)
        path.lineTo(position.x, position.y - halfDiagonal)
        path.lineTo(position.x + halfDiagonal, position.y)
        path.lineTo(position.x, position.y + halfDiagonal)

        path.close()

        drawPath(path, paint)
    }
}
