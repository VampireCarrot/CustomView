package com.lwd.customview.basic.path;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;


/**
 * User: LWD
 * Date: 2016/12/19
 * Email: 13102169005@163.com
 * Description:
 * 这三个方法都如字面意思一样，非常简单，这里就简单是叙述一下，不再过多讲解。
 * setPath 是 PathMeasure 与 Path 关联的重要方法，效果和 构造函数 中两个参数的作用是一样的。
 * isClosed 用于判断 Path 是否闭合，但是如果你在关联 Path 的时候设置 forceClosed 为 true 的话，这个方法的返回值则一定为true。
 * getLength 用于获取 Path 的总长度，在之前的测试中已经用过了
 */

public class AJMDPath extends View {
    private  static  final  String TAG = "AJMDPath";
    Path mPath;
    Paint mPaint;
    private float x0,y0;
    public AJMDPath(Context context) {
        super(context);


    }

    public AJMDPath(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AJMDPath(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        x0=this.getWidth()/2;
        y0=this.getHeight()/2;
        mPath = new Path();
        mPath.moveTo(x0,y0);
        for (int i=0; i<6145; i++){
            double angle = i*Math.PI/512;
            double radius = 0.3*angle;
            int x=(int)Math.round(radius*angle*Math.cos(angle));
            int y=(int)Math.round(radius*angle*Math.sin(angle));
            mPath.lineTo(x0+x,y0+y);
        }
        canvas.drawPath(mPath, mPaint);

    }
}
