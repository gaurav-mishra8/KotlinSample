package com.greenbot.juniper.ui.widget

import android.content.Context
import android.support.v4.content.ContextCompat
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.greenbot.juniper.R
import java.util.*
import android.animation.ValueAnimator
import android.graphics.*
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator


/**
 * Created by gaurav on 22/7/17.
 */
class TestCustomView(context: Context?) : View(context) {

    constructor(context: Context?, attributeSet: AttributeSet) : this(context)

    var paint: Paint
    var linePaint: Paint
    var textPaint: TextPaint
    var fullBitmap: Bitmap? = null
    var halfBitmap: Bitmap? = null
    private var newRadius: Float = 0f
    var timer: Timer

    init {
        paint = Paint()
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.textSize = 250f
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        paint.color = ContextCompat.getColor(context, R.color.colorAccent)

        linePaint = Paint()
        linePaint.color = ContextCompat.getColor(context, R.color.shimmer_background_color)

        textPaint = TextPaint()
        textPaint.color = ContextCompat.getColor(context, R.color.colorPrimary)
        textPaint.textSize = 250f

        timer = Timer()

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animateview()
    }

    override fun onDraw(canvas: Canvas?) {

        if (fullBitmap == null)
            fullBitmap = getBitmap(width, height, linePaint)

        if (halfBitmap == null)
            halfBitmap = getBitmap(width / 2, height / 2, paint)

        canvas?.drawBitmap(fullBitmap, 0f, 0f, null)
        canvas?.drawBitmap(halfBitmap, 100f, 100f, null)

      //  paint.color = ContextCompat.getColor(context, R.color.colorPrimary)


      //  canvas?.drawCircle(width.toFloat() / 2, height.toFloat() / 2, newRadius.toFloat(), paint)


        super.onDraw(canvas)
    }

    private fun getBitmap(width: Int, height: Int, paint: Paint): Bitmap {
        val bitmap = createBitmap(width, height)
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
    }


    fun animateview() {
        val animator = ValueAnimator.ofFloat(0f, 80f)
        animator.duration = 5000
        animator.addUpdateListener {
            animation ->
            newRadius = animation.animatedValue as Float
            invalidate()
        }
        animator.repeatCount = ValueAnimator.INFINITE
        animator.start()
    }
}