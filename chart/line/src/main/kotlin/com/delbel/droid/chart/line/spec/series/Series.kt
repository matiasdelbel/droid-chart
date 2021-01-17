package com.delbel.droid.chart.line.spec.series

import android.content.Context
import com.delbel.droid.chart.line.spec.Markers
import com.delbel.droid.chart.line.spec.series.line.Line
import com.delbel.droid.chart.line.spec.series.line.LineType
import com.delbel.droid.chart.line.spec.series.marker.Circle
import com.delbel.droid.chart.line.spec.series.marker.MarkerType

open class Series {

    internal var series: List<Float> = emptyList()
    internal val highestY get() = series.max() ?: 0f
    internal val totalMarkersInSeries get() = series.size

    private var lineType: LineType<*> = Line
    private var markerType: MarkerType<*> = Circle

    fun data(points: List<Float>): Series {
        series = points
        return this
    }

    fun line(specs: LineType<*>): Series {
        lineType = specs
        return this
    }

    fun markers(specs: MarkerType<*>): Series {
        markerType = specs
        return this
    }

    internal fun asPainters(context: Context) = listOf(
        lineType.asPainter(context, coordinates = Markers(series)),
        markerType.asPainter(context, coordinates =  Markers(series))
    )

    companion object : Series()
}
