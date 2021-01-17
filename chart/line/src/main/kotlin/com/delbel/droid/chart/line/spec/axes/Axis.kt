package com.delbel.droid.chart.line.spec.axes

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import com.delbel.droid.chart.line.R
import com.delbel.droid.chart.line.painter.axis.CanvasAxisPainter
import com.delbel.droid.chart.line.painter.axis.GridLinePainter
import com.delbel.droid.chart.line.painter.axis.XPainter
import com.delbel.droid.chart.line.painter.axis.YPainter

sealed class Axis<T : CanvasAxisPainter> {

    internal abstract fun asPainter(context: Context): T
}

object X : Axis<XPainter>() {

    internal var color = 0
        private set
    internal var stroke = R.dimen.line_chart_axis_stroke
        private set
    internal var labels: List<*> = emptyList<String>()
        private set

    fun color(@ColorRes color: Int): X {
        this.color = color
        return this
    }

    fun stroke(@DimenRes stroke: Int): X {
        this.stroke = stroke
        return this
    }

    fun labels(labels: List<*>): X {
        this.labels = labels
        return this
    }

    override fun asPainter(context: Context) = XPainter(context, x = this)
}

object Y : Axis<YPainter>() {

    internal var color = 0
        private set
    internal var stroke = R.dimen.line_chart_axis_stroke
        private set

    fun color(@ColorRes color: Int): Y {
        this.color = color
        return this
    }

    fun stroke(@DimenRes stroke: Int): Y {
        this.stroke = stroke
        return this
    }

    override fun asPainter(context: Context) = YPainter(context, y = this)
}

object GridLine : Axis<GridLinePainter>() {

    internal var color = R.color.line_chart_light_gray
        private set
    internal var stroke = R.dimen.line_chart_axis_helper_line_stroke
        private set

    fun color(@ColorRes color: Int): GridLine {
        this.color = color
        return this
    }

    fun stroke(@DimenRes stroke: Int): GridLine {
        this.stroke = stroke
        return this
    }

    override fun asPainter(context: Context) = GridLinePainter(context, gridLine = this)
}
