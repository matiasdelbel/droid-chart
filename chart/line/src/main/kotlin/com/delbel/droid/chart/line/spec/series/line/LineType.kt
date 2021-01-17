package com.delbel.droid.chart.line.spec.series.line

import android.content.Context
import com.delbel.droid.chart.line.painter.series.CanvasSeriesPainter
import com.delbel.droid.chart.line.spec.Markers

interface LineType<T: CanvasSeriesPainter> {

     fun  asPainter(context: Context, coordinates: Markers): T
}
