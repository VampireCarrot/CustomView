package com.lwd.customview.basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * User: LWD
 * Date: 2016/12/15
 * Email: 13102169005@163.com
 * Description:
 */

public class PaintExerciseView extends View {


    public PaintExerciseView(Context context) {
        super(context);
    }

    public PaintExerciseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 初始化画笔
         */
        Paint paint = new Paint();
        /**
         * 设置画笔颜色
         */
        paint.setColor(Color.DKGRAY);
        /**
         * 设置是否抗锯齿
         */
        paint.setAntiAlias(true);
        /**
         * Paint.Style.FILL：填充内部
         * Paint.Style.FILL_AND_STROKE  ：填充内部和描边
         * Paint.Style.STROKE  ：描边
         */
        paint.setStyle(Paint.Style.STROKE);
        /**
         * 设置描边的线宽
         */
        paint.setStrokeWidth(3);
        /**
         * 绘制圆
         * 参数1：圆心X坐标
         * 参数2：圆心Y坐标
         * 参数3：圆的半径
         * 参数4：画笔
         */
        canvas.drawCircle(40,40,30,paint);
        /**
         * 绘制圆
         * 参数1：矩形左上角X坐标
         * 参数2：矩形左上角Y坐标
         * 参数3：矩形右下角X坐标
         * 参数4：画笔右下角Y坐标
         * 参数5：画笔
         */
        canvas.drawRect(10,90,70,150,paint);
        /**
         * 绘制圆
         * 参数1：矩形左上角X坐标
         * 参数2：矩形左上角Y坐标
         * 参数3：矩形右下角X坐标
         * 参数4：画笔右下角Y坐标
         * 参数5：画笔
         */
        canvas.drawRect(10,170,70,200,paint);

        canvas.drawOval(new RectF(10, 220, 70, 250), paint);

        Path path = new Path();//三角形

        path.moveTo(10,330);

        path.lineTo(70,330);

        path.lineTo(40,270);

        path.close();

        canvas.drawPath(path,paint);



    }

}
