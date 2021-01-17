package android.graphics

/* Chart coordinates inside the axes */

val Canvas.chartLeft get() = width * 0.06f

val Canvas.chartRight get() = width - (width * 0.1f)

val Canvas.chartBottom get() = height - (height * 0.028f)

val Canvas.chartTop get() = height * 0.1f

/* Position a point in the chart  */

fun Canvas.x(point: Int, total: Int) = (chartRight / (total) * point) + chartLeft

fun Canvas.y(point: Int, total: Int) = chartTop + (chartBottom - chartTop) / total * point

fun Canvas.y(point: Float, highestY: Float): Float {
    val y = chartBottom - ((chartBottom - chartTop) / highestY * point)
    return if (y == 0f) chartTop else y
}