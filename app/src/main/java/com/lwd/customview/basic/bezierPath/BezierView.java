package com.lwd.customview.basic.bezierPath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * User: LWD
 * Date: 2016/12/20
 * Email: 13102169005@163.com
 * Description:
 */

public class BezierView extends View {

    private Path mPath;
    private Paint mPaint;
    private Point startPoint;
    private Point midPoint;
    private Point endPoint;


    public BezierView(Context context) {
        this(context,null);
    }

    public BezierView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inIt();
    }

    private void inIt() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
        //抗锯齿
        mPaint.setAntiAlias(true);
        //防抖动
        mPaint.setDither(true);
        mPath = new Path();
        startPoint = new Point(10,10);
        midPoint = new Point(300,300);
        endPoint = new Point(900,900);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 重置路径
        mPath.reset();
        // 起点
        mPath.moveTo(startPoint.x, startPoint.y);
        // 重要的就是这句
        mPath.quadTo(midPoint.x, midPoint.y, endPoint.x, endPoint.y);
        // 画路径
        canvas.drawPath(mPath, mPaint);

        canvas.drawPoint(midPoint.x, midPoint.y, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                midPoint.x = (int) event.getX();
                midPoint.y = (int) event.getY();
                invalidate();
                break;
        }
        return true;
    }
}
