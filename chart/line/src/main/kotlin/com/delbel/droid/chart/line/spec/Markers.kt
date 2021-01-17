package com.delbel.droid.chart.line.spec

import android.graphics.Canvas
import android.graphics.x
import android.graphics.y
import com.delbel.droid.chart.line.spec.series.Coordinate

class Markers(private val series: List<Float>) {

    internal fun coordinates(canvas: Canvas, highestY: Float) = series.mapIndexed { index, value ->
        Coordinate(
            x = canvas.x(point = index, total = series.size - 1),
            y = canvas.y(point = value, highestY = highestY)
        )
    }
}