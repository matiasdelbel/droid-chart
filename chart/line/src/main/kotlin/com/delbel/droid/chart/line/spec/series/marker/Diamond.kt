package com.delbel.droid.chart.line.spec.series.marker

import android.content.Context
import androidx.annotation.ColorRes
import com.delbel.droid.chart.line.R
import com.delbel.droid.chart.line.painter.series.marker.DiamondPainter
import com.delbel.droid.chart.line.spec.Markers

open class Diamond : MarkerType<DiamondPainter> {

    @ColorRes
    internal var color: Int = R.color.line_chart_line_segment_default_color

    fun color(@ColorRes color: Int): Diamond {
        this.color = color
        return this
    }

    override fun asPainter(context: Context, coordinates: Markers) =
        DiamondPainter(context, coordinates, diamond = this)

    companion object : Diamond()
}
