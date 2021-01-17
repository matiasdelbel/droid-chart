package com.delbel.droid.chart.line.spec.series.line

import android.content.Context
import androidx.annotation.ColorRes
import com.delbel.droid.chart.line.R
import com.delbel.droid.chart.line.painter.series.line.LinePainter
import com.delbel.droid.chart.line.spec.Markers

open class Line : LineType<LinePainter> {

    @ColorRes
    internal var color: Int = R.color.line_chart_line_segment_default_color
        private set
    internal var isDashedLine: Boolean = false
        private set

    fun color(@ColorRes color: Int): Line {
        this.color = color
        return this
    }

    fun dashed(isDashed: Boolean): Line {
        isDashedLine = isDashed
        return this
    }

    override fun asPainter(context: Context, coordinates: Markers) =
        LinePainter(context, coordinates, line = this)

    companion object : Line()
}
