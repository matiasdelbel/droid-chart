package com.delbel.droid.chart.line.painter.series.line

import android.content.Context
import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.Path
import androidx.core.content.ContextCompat.getColor
import com.delbel.droid.chart.line.R
import com.delbel.droid.chart.line.painter.series.CanvasSeriesPainter
import com.delbel.droid.chart.line.spec.Chart
import com.delbel.droid.chart.line.spec.series.Coordinate
import com.delbel.droid.chart.line.spec.Markers
import com.delbel.droid.chart.line.spec.series.line.Line

class LinePainter(
    private val context: Context,
    private val coordinates: Markers,
    private val line: Line
) : CanvasSeriesPainter {

    private var paint = Paint().apply {
        color = getColor(context, line.color)
        strokeWidth = context.resources.getDimension(R.dimen.line_chart_line_segment_stroke)
        isAntiAlias = true
        style = Paint.Style.STROKE
        pathEffect = if (line.isDashedLine) DashPathEffect(DASH_INTERVAL, NO_PHASE) else null
    }
    private val path: Path = Path()

    override fun draw(canvas: Canvas, chart: Chart) {
        val coordinates = coordinates.coordinates(canvas, chart.highestY)

        coordinates.movePathToFirstCoordinateIfCan()
        coordinates.updatePathBetweenCoordinates()

        canvas.drawPath(path, paint)
        path.reset()
    }

    private fun List<Coordinate>.movePathToFirstCoordinateIfCan() =
        firstOrNull()?.let { path.moveTo(it.x, it.y) }

    private fun List<Coordinate>.updatePathBetweenCoordinates() {
        for (index in 0..size)
            if (index < size - 1) path.lineTo(this[index + 1].x, this[index + 1].y)
    }

    private companion object {
        val DASH_INTERVAL = floatArrayOf(50f, 30f)
        const val NO_PHASE = 0f
    }
}
