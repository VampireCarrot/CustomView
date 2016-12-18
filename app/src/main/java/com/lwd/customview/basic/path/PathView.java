package com.lwd.customview.basic.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.lwd.customview.utils.PathParserUtils;
import com.lwd.customview.utils.StoreHousePath;


/**
 * User: LWD
 * Date: 2016/12/16
 * Email: 13102169005@163.com
 * Description:
 */

public class PathView extends View {
    Path mPath;
    Paint mPaint;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();
        /**
         * 工具类
         */
        mPath = PathParserUtils.getPathFromArrayFloatList(StoreHousePath.getPath("ZhangXuTong"));
        canvas.drawPath(mPath,mPaint);
    }
}
