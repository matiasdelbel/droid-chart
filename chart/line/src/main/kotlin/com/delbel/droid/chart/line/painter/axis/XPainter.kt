package com.delbel.droid.chart.line.painter.axis

import android.content.Context
import android.graphics.*
import androidx.core.content.ContextCompat.getColor
import com.delbel.droid.chart.line.R
import com.delbel.droid.chart.line.spec.Chart
import com.delbel.droid.chart.line.spec.axes.X

class XPainter(private val context: Context, private val x: X) : CanvasAxisPainter {

    private val labels = x.labels.map { it.toString() }

    private val paint: Paint = Paint().apply {
        color = getColor(context, x.color)
        strokeWidth = context.resources.getDimension(x.stroke)
        textSize = context.resources.getDimension(R.dimen.line_chart_axis_text_size)
    }

    override fun draw(canvas: Canvas, chart: Chart) {
        canvas.drawAxis()
        canvas.drawLabels()
    }

    private fun Canvas.drawAxis() =
        drawLine(chartLeft, chartBottom, chartRight + chartLeft, chartBottom, paint)

    private fun Canvas.drawLabels() = labels
        .withIndex()
        .forEach { drawText(it.value, x(point = it.index, total = labels.size - 1), height.toFloat(), paint) }
}
