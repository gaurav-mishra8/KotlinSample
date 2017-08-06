package com.greenbot.juniper.ui.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.greenbot.juniper.R
import java.util.*
import android.animation.ValueAnimator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator


/**
 * Created by gaurav on 22/7/17.
 */
class ShimmerLayout(context: Context?) : View(context) {

    constructor(context: Context?, attributeSet: AttributeSet) : this(context)

    var paint: Paint
    var textPaint: TextPaint
    lateinit var customBitmap: Bitmap
    private var newRadius: Int = 0


    var timer: Timer

    init {
        paint = Paint()
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.color = ContextCompat.getColor(context, R.color.colorAccent)

        textPaint = TextPaint()
        textPaint.color = ContextCompat.getColor(context, R.color.colorPrimary)
        textPaint.textSize = 250f

        timer = Timer()

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        /*timer.schedule(object : TimerTask() {
            override fun run() {
                invalidate()
            }
        }, 1000, 2000)*/
        animateview()
    }

    override fun onDraw(canvas: Canvas?) {
        val halfWidth = canvas?.width ?: 100
        val halfHeight = canvas?.height ?: 100

        Log.d("onDraw", " repainting "+halfWidth+" "+halfHeight)


        //canvas?.drawText(newRadius.toString(), 150f, 400f, textPaint)

        canvas?.drawCircle((halfWidth/2).toFloat(), (halfHeight/2).toFloat(), newRadius.toFloat(), paint)

        customBitmap = getBitmap(halfWidth, halfHeight)
        // canvas?.drawBitmap(customBitmap, 0f, 0f, null)
        super.onDraw(canvas)
    }

    private fun getBitmap(halfWidth: Int, halfHeight: Int): Bitmap {
        val bitmap = createBitmap(halfWidth / 2, halfHeight / 2)
        val canvas: Canvas = Canvas()
        canvas.setBitmap(bitmap)
        canvas.drawPaint(paint)
        return bitmap
    }

    fun createBitmap(width: Int, height: Int): Bitmap {
        return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        /*timer.cancel()
        timer.purge()*/
    }


    fun animateview() {
        val animator = ValueAnimator.ofInt(50, 60)
        animator.duration = 5000
        animator.interpolator = BounceInterpolator()
        animator.addUpdateListener {
            animation ->
            newRadius = animation.animatedValue as Int
            invalidate()
        }
        animator.repeatCount = ValueAnimator.REVERSE
        animator.start()
    }
}