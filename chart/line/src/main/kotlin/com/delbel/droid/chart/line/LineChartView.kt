package com.delbel.droid.chart.line

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.delbel.droid.chart.line.spec.Chart
import com.delbel.droid.chart.line.spec.axes.Axis
import com.delbel.droid.chart.line.spec.series.Series

class LineChartView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val chart = Chart()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        chart drawOn canvas
    }

    operator fun plusAssign(axis: Axis<*>) {
        chart[axis] = axis.asPainter(context)
    }

    operator fun plusAssign(series: Series) {
        chart[series] = series.asPainters(context)
    }
}
