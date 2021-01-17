package com.delbel.droid.chart.line.spec.series.marker

import android.content.Context
import com.delbel.droid.chart.line.painter.series.CanvasSeriesPainter
import com.delbel.droid.chart.line.spec.Markers

interface MarkerType<T : CanvasSeriesPainter> {

    fun asPainter(context: Context, coordinates: Markers): T
}
