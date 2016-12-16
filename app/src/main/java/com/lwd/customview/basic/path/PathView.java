package com.lwd.customview.basic.path;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.mcxtzhang.pathanimlib.PathAnimHelper;
import com.mcxtzhang.pathanimlib.res.StoreHousePath;
import com.mcxtzhang.pathanimlib.utils.PathParserUtils;

/**
 * User: LWD
 * Date: 2016/12/16
 * Email: 13102169005@163.com
 * Description:
 */

public class PathView extends View{

    private Paint mPaint;
    private Path mPath;
    private Path mAnimPath;
    protected int mColorBg = Color.GRAY;//背景色
    protected int mColorFg = Color.RED;//前景色 填充色
    protected PathAnimHelper mPathAnimHelper;//Path动画工具类
    protected int mPaddingLeft, mPaddingTop;
    public PathView(Context context) {
        super(context);

    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint = new Paint();
        mPath = new Path();
        mAnimPath = new Path();

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);


        mPath =  PathParserUtils.getPathFromArrayFloatList(StoreHousePath.getPath("HELLO", 1.1f, 16));
        mPathAnimHelper =new PathAnimHelper(this, mPath, mAnimPath);
        mPathAnimHelper.setInfinite(false);
        mPathAnimHelper.setAnimTime(3000);

        //平移
        canvas.translate(mPaddingLeft, mPaddingTop);

        //先绘制底，
        mPaint.setColor(mColorBg);
        canvas.drawPath(mPath, mPaint);

        //再绘制前景，mAnimPath不断变化，不断重绘View的话，就会有动画效果。
        mPaint.setColor(mColorFg);
        canvas.drawPath(mAnimPath, mPaint);
        startAnim();

    }

    /**
     * 执行循环动画
     */
    public void startAnim() {
        mPathAnimHelper.startAnim();
    }
    /**
     * 清除并停止动画
     */
    public void clearAnim() {
        mPathAnimHelper.stopAnim();
        mAnimPath.reset();
        mAnimPath.lineTo(0, 0);
        invalidate();
    }

    public void onAnimationUpdate(ValueAnimator animation) {
        //TODO
    }
}
