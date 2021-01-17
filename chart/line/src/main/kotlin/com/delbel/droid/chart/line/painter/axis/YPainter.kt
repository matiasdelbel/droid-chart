package com.delbel.droid.chart.line.painter.axis

import android.content.Context
import android.graphics.*
import androidx.core.content.ContextCompat.getColor
import com.delbel.droid.chart.line.R
import com.delbel.droid.chart.line.spec.Chart
import com.delbel.droid.chart.line.spec.axes.Y

class YPainter(private val context: Context, private val y: Y) : CanvasAxisPainter {

    private var paint = Paint().apply {
        color = getColor(context, y.color)
        strokeWidth = context.resources.getDimension(y.stroke)
        textSize = context.resources.getDimension(R.dimen.line_chart_axis_text_size)
    }

    override fun draw(canvas: Canvas, chart: Chart) {
        canvas.drawYAxis()
        canvas.drawLabels(chart)
    }

    private fun Canvas.drawYAxis() = drawLine(chartLeft, chartBottom, chartLeft, chartTop, paint)

    private fun Canvas.drawLabels(chart: Chart) {
        val total = (chart.highestY / (chart.totalMarkersInBiggestSeries - 1)).toInt()
        for (index in 0..total) {
            val label = (chart.highestY - ((chart.totalMarkersInBiggestSeries - 1) * index)).toInt().toString()
            val y = y(point = index, total = total)

            drawText(label, LABEL_X_COORDINATE, y, paint)
        }
    }

    private companion object {
        const val LABEL_X_COORDINATE = 0f
    }
}