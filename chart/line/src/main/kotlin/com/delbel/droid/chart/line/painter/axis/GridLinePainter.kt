package com.delbel.droid.chart.line.painter.axis

import android.content.Context
import android.graphics.*
import androidx.core.content.ContextCompat.getColor
import com.delbel.droid.chart.line.spec.Chart
import com.delbel.droid.chart.line.spec.axes.GridLine

class GridLinePainter(private val context: Context, private val gridLine: GridLine) : CanvasAxisPainter {

    private var paint = Paint().apply {
        color = getColor(context, gridLine.color)
        strokeWidth = context.resources.getDimension(gridLine.stroke)
    }

    override fun draw(canvas: Canvas, chart: Chart) = canvas
        .drawGridLine(chart = chart)

    private fun Canvas.drawGridLine(chart: Chart) {
        val total = (chart.highestY / (chart.totalMarkersInBiggestSeries - 1)).toInt()

        for (index in 0..total) {
            val y = y(point = index, total = total)
            drawLine(chartLeft, y, chartRight + chartLeft, y, paint)
        }
    }
}
