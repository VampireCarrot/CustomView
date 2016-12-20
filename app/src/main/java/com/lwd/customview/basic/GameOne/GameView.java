package com.lwd.customview.basic.GameOne;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import com.lwd.customview.utils.LogUtil;

import static android.graphics.Paint.Style.FILL;
import static android.graphics.Paint.Style.STROKE;

/**
 * User: LWD
 * Date: 2016/12/20
 * Email: 13102169005@163.com
 * Description:
 */

public class GameView extends View {
    private static String TAG  = "Game————》";

    /**
     * 定义旋转的速度(由高到低)
     */
    enum SPEED {
        LEVEL1,
        LEVEL2,
        LEVEL3,
        LEVEL4,
        LEVEL5
    }

    //定义障碍物的画笔
    private Paint paint_obst;
    //定义画笔
    private Paint paint_orbit;
    //定义轨迹的路径
    private Path path_orbit;
    private PathMeasure pathMeasure;

    //上下文
    private Context context;

    //定义左边球的圆心
    private Point lPoint;
    //定义旋转的圆心
    private Point mPoint;
    //定义右边旋转的圆心
    private Point rPoint;
    //定义小球的半径
    private Float Ball_r;
    private int Ball_R;
    private int Width;
    private int height;

    public GameView(Context context) {
        this(context,null);
    }

    public GameView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        //初始化工具
        initialize();
    }

    private void initialize() {
        /**
         * 主要用于绘制随机矩形
         */
        paint_obst = new Paint();
        paint_obst.setDither(true);
        paint_obst.setStyle(Style.FILL);
        paint_obst.setColor(Color.BLACK);
        paint_obst.setAntiAlias(true);

        /**
         * 绘制轨迹
         */
        paint_orbit = new Paint();
        paint_orbit.setDither(true);
        paint_orbit.setStyle(FILL);
        paint_orbit.setColor(Color.BLACK);
        paint_orbit.setAntiAlias(true);

        lPoint = new Point();
        mPoint = new Point();
        rPoint = new Point();




    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        Width = getMeasuredWidth();
        height = getMeasuredHeight();


        LogUtil.d(TAG+"Width",Width);
        LogUtil.d(TAG+"height",height);
        lPoint.x = (int) (Width*0.33);
        lPoint.y = (int) (height-(Width*0.33));

        LogUtil.d(TAG+"lPoint.x",lPoint.x);
        LogUtil.d(TAG+"lPoint.y",lPoint.y);

        mPoint.x =(int) (Width*0.5);
        mPoint.y =(int) (height-(Width*0.33));
        LogUtil.d(TAG+"mPoint.x",mPoint.x);
        LogUtil.d(TAG+"mPoint.y",mPoint.y);
        rPoint.x =(int) (Width*0.66);
        rPoint.y = (int) (height-(Width*0.33));
        LogUtil.d(TAG+"rPoint.x",rPoint.x);
        LogUtil.d(TAG+"rPoint.y",rPoint.y);
        Ball_r = (float) (40);
        Ball_R = (rPoint.x-lPoint.x)/2;
        setMeasuredDimension(Width,height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Path mPath = new Path();
        mPath.moveTo(rPoint.x,rPoint.y);
        for (int i = 0; i < 361; i += 1) {
            int x = (int) (mPoint.x- Ball_R* Math.sin(Math.PI * (i - 90) / 180));
            int y = (int) (mPoint.y - +Ball_R * Math.cos(Math.PI * (i - 90) / 180));
            mPath.lineTo(x,y);
        }
        paint_orbit.reset();
        paint_orbit.setColor(Color.GRAY);
        paint_orbit.setStyle(STROKE);
        canvas.drawPath(mPath,paint_orbit);

        //绘制左边圆
        paint_orbit.reset();
        paint_orbit.setColor(Color.BLACK);
        canvas.drawCircle(lPoint.x,lPoint.y,Ball_r, paint_orbit);
        //绘制右边圆
        paint_orbit.reset();
        paint_orbit.setColor(Color.RED);
        canvas.drawCircle(rPoint.x,rPoint.y,Ball_r, paint_orbit);



    }
}
