package com.delbel.droid.chart.line.painter

import com.delbel.droid.chart.line.spec.Chart

 interface ChartPainter<Canvas> {

    fun draw(canvas: Canvas, chart: Chart)
}