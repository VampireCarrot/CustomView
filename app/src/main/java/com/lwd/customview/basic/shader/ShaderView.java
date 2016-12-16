package com.lwd.customview.basic.shader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.lwd.customview.R;

/**
 * User: LWD
 * Date: 2016/12/16
 * Email: 13102169005@163.com
 * Description:　　
 *  Shader类包括了5个直接子类，分别为：BitmapShader、ComposeShader、LinearGradient、RadialGradient以及SweepGradient。
 *  BitmapShader用于图像渲染；
 *  ComposeShader用于混合渲染；
 *  LinearGradient用于线性渲染；
 *  RadialGradient用于环形渲染；
 *  SweepGradient则用于梯度渲染。
 *　使用Shader类进行图像渲染时，首先需要构建Shader对象，然后通过Paint的setShader()方法来设置渲染对象，最后将这个Paint对象绘制到屏幕上即可。
 *　有一点需要注意，使用不同的方式渲染图像时需要构建不同的对象。
 *
 * Shader.TileMode有3种参数:
 *      CLAMP:如果渲染器超出原始边界范围，则会复制边缘颜色对超出范围的区域进行着色
 *      REPEAT:在横向和纵向上以平铺的形式重复渲染位图
 *      MIRROR:在横向和纵向上以镜像的方式重复渲染位图
 *
 */

public class ShaderView extends View {

    private Paint mPaint;
    private Shader mShader;
    private Bitmap mBitmap;
    public ShaderView(Context context) {
        super(context);
    }

    public ShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        mPaint.setAntiAlias(true);

        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        mShader = new BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        mPaint.setShader(mShader);
        canvas.drawBitmap(mBitmap,200,100, mPaint);
    }
}
