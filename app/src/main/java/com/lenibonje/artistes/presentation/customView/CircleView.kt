package com.lenibonje.artistes.presentation.customView

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.lenibonje.artistes.R

class CircleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var paint: Paint = Paint()
    var centerOfX = 340F
    var centerOfY = 340F
    var radiusOfCircleView = 140F
    var isCenter = false

    init {
        val attributeArray: TypedArray =
            context.theme.obtainStyledAttributes(
                attrs, R.styleable.circleview, 0, 0
            )

        paint.color = attributeArray.getColor(
            R.styleable.circleview_circle_background,
            ContextCompat.getColor(context, android.R.color.background_dark)
        )

        isCenter = attributeArray.getBoolean(R.styleable.circleview_onCenter, false)
        radiusOfCircleView = attributeArray.getDimension(
            R.styleable.circleview_circle_radius, 140F)

        paint.strokeWidth = 40F
        paint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        if (isCenter){
            centerOfX = (width / 2).toFloat()
            centerOfY = (height / 2).toFloat()
        }
        canvas?.drawCircle(centerOfX, centerOfY, radiusOfCircleView, paint)
        super.onDraw(canvas)
    }
}