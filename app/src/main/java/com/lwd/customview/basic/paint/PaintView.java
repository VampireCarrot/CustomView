package com.lwd.customview.basic.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;


/**
 * User: LWD
 * Date: 2016/12/15
 * Email: 13102169005@163.com
 * Description:
 */

public class PaintView extends View {

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
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
         * 1：绘制圆
         * 参数1：圆心X坐标
         * 参数2：圆心Y坐标
         * 参数3：圆的半径
         * 参数4：画笔
         */
        canvas.drawCircle(40,40,30,paint);
        /**
         * 2：绘制矩形
         * 参数1：矩形左上角X坐标
         * 参数2：矩形左上角Y坐标
         * 参数3：矩形右下角X坐标
         * 参数4：画笔右下角Y坐标
         * 参数5：画笔
         */
        canvas.drawRect(10,90,70,150,paint);
        /**
         * 3：绘制长方形
         * 参数1：矩形左上角X坐标
         * 参数2：矩形左上角Y坐标
         * 参数3：矩形右下角X坐标
         * 参数4：画笔右下角Y坐标
         * 参数5：画笔
         */
        canvas.drawRect(10,170,70,200,paint);
        /**
         * 4：绘制椭圆 drawOval
         * Rect是使用int类型作为数值，RectF是使用float类型作为数值（精度不同）
         * 参数1：矩形左上角X坐标
         * 参数2：矩形左上角Y坐标
         * 参数3：矩形右下角X坐标
         * 参数4：画笔右下角Y坐标
         * 参数5：画笔
         */
        canvas.drawOval(new RectF(10, 220, 70, 250), paint);

        /**
         * 5：绘制三角形
         * Rect是使用int类型作为数值，RectF是使用float类型作为数值（精度不同）
         * 参数1：矩形左上角X坐标
         * 参数2：矩形左上角Y坐标
         * 参数3：矩形右下角X坐标
         * 参数4：画笔右下角Y坐标
         * 参数5：画笔
         */
        Path path = new Path();//三角形
        path.moveTo(10,330);
        path.lineTo(70,330);
        path.lineTo(40,270);
        path.close();
        canvas.drawPath(path,paint);

        /**
         * 6：绘制梯形
         * 最重要的就是movtTo和close,如果是Style.FILL的话，不设置close,也没有区别，可是如果是STROKE模式，
         * 如果不设置close,图形不封闭。
         * 当然，你也可以不设置close，再添加一条线，效果一样。
         */
        Path path2 = new Path();//三角形
        path2.moveTo(10,410);//绘画基点
        path2.lineTo(70,410);
        path2.lineTo(55,350);
        path2.lineTo(25,350);
        path2.close();//把开始的点和最后的点连接在一起，构成一个封闭图形
        canvas.drawPath(path2,paint);

        /**
         * 绘制各种渐变图型 （大家可去改一下Style 属性）
         */
        Paint paint2 = new Paint();
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
        Shader mShader = new LinearGradient(0,0,100,100,
                new int[]{Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW},
                null,
                Shader.TileMode.REPEAT);
        paint2.setShader(mShader);
        /*画一个渐变色圆*/
        canvas.drawCircle(200,40,30, paint2);
        /*画一个渐变色正方形*/
        canvas.drawRect(170, 90, 230, 150, paint2);
        /*画一个渐变色长方形*/
        canvas.drawRect(170, 170, 230,200, paint2);
        /*画一个渐变色椭圆*/
        RectF re3=new RectF(170,220,230,250);
        canvas.drawOval(re3, paint2);
        /*画一个渐变色三角形*/
        Path path4=new Path();
        path4.moveTo(170,330);
        path4.lineTo(230,330);
        path4.lineTo(200,270);
        path4.close();
        canvas.drawPath(path4, paint2);
        /*画一个渐变色梯形*/
        Path path5=new Path();
        path5.moveTo(170, 410);
        path5.lineTo(230,410);
        path5.lineTo(215,350);
        path5.lineTo(185, 350);
        path5.close();
        canvas.drawPath(path5, paint2);
        paint.setTextSize(28);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        canvas.drawText("绘制圆", 300, 50, paint);
        canvas.drawText("绘制矩形", 300, 120, paint);
        canvas.drawText("绘制矩形", 300, 190, paint);
        canvas.drawText("绘制椭圆", 300, 250, paint);
        canvas.drawText("绘制三角形", 300, 320, paint);
        canvas.drawText("绘制梯形", 300, 390, paint);
    }
}
