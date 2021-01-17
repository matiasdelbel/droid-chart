package com.delbel.droid.chart.line.spec

import android.graphics.Canvas
import com.delbel.droid.chart.line.painter.ChartPainter
import com.delbel.droid.chart.line.painter.axis.CanvasAxisPainter
import com.delbel.droid.chart.line.painter.series.CanvasSeriesPainter
import com.delbel.droid.chart.line.spec.axes.Axis
import com.delbel.droid.chart.line.spec.series.Series

class Chart {

    private val chartPainters = mutableListOf<ChartPainter<Canvas>>()

    var totalMarkersInBiggestSeries = 0
        private set
    var highestY = 0f
        private set

    infix fun drawOn(canvas: Canvas) = chartPainters.forEach { it.draw(canvas, chart = this) }

    operator fun set(axis: Axis<*>, painter: CanvasAxisPainter) {
        chartPainters += painter
    }

    operator fun set(series: Series, painters: List<CanvasSeriesPainter>) {
        updateReferenceValuesIfNeededWith(series)

        chartPainters.addAll(painters)
    }

    private fun updateReferenceValuesIfNeededWith(series: Series) {
        if (series.highestY > highestY)
            highestY = series.highestY

        if (series.totalMarkersInSeries > totalMarkersInBiggestSeries)
            totalMarkersInBiggestSeries = series.totalMarkersInSeries
    }
}
