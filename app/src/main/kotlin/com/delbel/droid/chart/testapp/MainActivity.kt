package com.delbel.droid.chart.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delbel.droid.chart.line.LineChartView
import com.delbel.droid.chart.line.spec.axes.GridLine
import com.delbel.droid.chart.line.spec.axes.X
import com.delbel.droid.chart.line.spec.axes.Y
import com.delbel.droid.chart.line.spec.series.Series
import com.delbel.droid.chart.line.spec.series.line.Line
import com.delbel.droid.chart.line.spec.series.marker.Circle
import com.delbel.droid.chart.line.spec.series.marker.Diamond

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chart = findViewById<LineChartView>(R.id.graph_view)

        chart += GridLine
            .color(R.color.line_chart_light_gray)
            .stroke(R.dimen.line_chart_axis_helper_line_stroke)

        chart += X
            .color(R.color.lineChartAxes)
            .stroke(R.dimen.line_chart_axis_stroke)
            .labels(listOf("S", "M", "T", "W", "T", "F", "S"))

        chart += Y
            .color(R.color.lineChartAxes)
            .stroke(R.dimen.line_chart_axis_stroke)

        chart += Series
            .data(points = listOf(0f, 10f, 20f, 30f, 40f, 50f, 60f))
            .line(specs = Line
                .dashed(isDashed = true)
                .color(R.color.lineChartColor)
            )
            .markers(specs = Diamond.color(R.color.lineChartColor))

        chart += Series
            .data(points = listOf(48f, 42f, 30f, 18f, 30f, 12f, 6f))
            .line(specs = Line
                .dashed(isDashed = false)
                .color(R.color.lineChartColorTwo)
            )
            .markers(specs = Circle.color(R.color.lineChartColorTwo))
    }
}
