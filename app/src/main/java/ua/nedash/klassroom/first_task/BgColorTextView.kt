package ua.nedash.klassroom.first_task

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import ua.nedash.klassroom.R

class BgColorTextView : AppCompatTextView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun draw(canvas: Canvas) {
        val lineCount = layout.lineCount
        val rect = Rect()
        val paint = Paint()
        paint.color = context.getColor(R.color.white)

        for (i in 0 until lineCount) {
            rect.top = layout.getLineTop(i)
            rect.left = layout.getLineLeft(i).toInt() - paddingStart
            rect.right = layout.getLineRight(i).toInt() + (2 * paddingStart)
            rect.bottom =
                (layout.getLineBottom(i) - (if (i + 1 == lineCount) 0 else layout.spacingAdd).toInt())
            canvas.drawRect(rect, paint)
        }
        super.draw(canvas)
    }
}