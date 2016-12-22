package com.lwd.customview.basic.GameOne;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.lwd.customview.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

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
    //定义速度
    private static final  int SPEED1 = 1;
    private static final  int SPEED2 = 2;
    private static final  int SPEED3 = 3;
    private int CurrentSpeed  = 1;
    //定义障碍物的画笔
    private Paint paint_obst;
    //定义画笔
    private Paint paint_orbit;
    //定义轨迹的路径
    private Path path_orbit;
    private PathMeasure pathMeasure;
    //
    private boolean isRun = true;
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
    private int count = 180;
    private List<RectModl> RectList;

    private float CurrontPosition = 0f;
    public Handler mHandler=new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch(msg.what)
            {
                case 1:

                    Point startPoint = new Point(0,0);
                    RectModl rect = new RectModl(startPoint,RandomRect.getRandomRect());
                    RectList.add(rect);
                    invalidate();
                    LogUtil.d(TAG+"已经存在障碍物：",RectList.size());
                    break;
                case 2:
                    CurrontPosition+=25.0;
                    invalidate();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };


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
        RectList = new ArrayList<>();
        new Thread(new CrateRandomRect()).start();
        new Thread(new RectThred()).start();

    }

    private void initialize() {
        /**
         * 主要用于绘制随机矩形
         */
        paint_obst = new Paint();
        paint_obst.setDither(true);
        paint_obst.setStyle(Style.FILL);
        paint_obst.setColor(Color.parseColor("#3366cc"));
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


        lPoint.x = (int) (Width*0.33);
        lPoint.y = (int) (height-(Width*0.33));


        mPoint.x =(int) (Width*0.5);
        mPoint.y =(int) (height-(Width*0.33));

        rPoint.x =(int) (Width*0.66);
        rPoint.y = (int) (height-(Width*0.33));

        Ball_r = (float) (40);
        Ball_R = (rPoint.x-lPoint.x)/2;
        setMeasuredDimension(Width,height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        path_orbit = new Path();
        path_orbit.moveTo(mPoint.x+Ball_r,mPoint.y);
        for (int i = 0; i < 361; i += 1) {
            int x = (int) (mPoint.x- Ball_R* Math.sin(Math.PI * (i - 90) / 180));
            int y = (int) (mPoint.y - +Ball_R * Math.cos(Math.PI * (i - 90) / 180));
            path_orbit.lineTo(x,y);
        }
        path_orbit.close();
        paint_orbit.reset();
        paint_orbit.setColor(Color.GRAY);
        paint_orbit.setStyle(STROKE);
        canvas.drawPath(path_orbit,paint_orbit);



        //绘制左边圆
        paint_obst.reset();
        paint_obst.setColor(Color.BLACK);
        canvas.drawCircle(lPoint.x,lPoint.y,Ball_r, paint_obst);
        //绘制右边圆
        paint_obst.reset();
        paint_obst.setColor(Color.RED);
        canvas.drawCircle(rPoint.x,rPoint.y,Ball_r, paint_obst);

        /**
         * 绘制障碍物
         */
        if(RectList.size()>0){
            for(int i = 0;i<RectList.size();i++){
                RectModl rectM = RectList.get(i);
                canvas.drawRect(
                        rectM.getStartPoint().x,
                        rectM.getStartPoint().y,
                        rectM.getEndPoint().x,
                        rectM.getEndPoint().y,
                        paint_obst);
            }
        }

    }

    class  CrateRandomRect implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(5000);
                    mHandler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class  RectThred implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    mHandler.sendEmptyMessage(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float x = event.getX();

            if(x>Width/2){
                count +=3;
                lPoint.x = (int) (mPoint.x- Ball_R* Math.sin(Math.PI * (count - 90) / 180));
                lPoint.y = (int) (mPoint.y - +Ball_R * Math.cos(Math.PI * (count - 90) / 180));
                rPoint.x = (int) (mPoint.x- Ball_R* Math.sin(Math.PI * (count + 90) / 180));
                rPoint.y = (int) (mPoint.y - +Ball_R * Math.cos(Math.PI * (count + 90) / 180));
            }else{
                count-=3;
                lPoint.x = (int) (mPoint.x- Ball_R* Math.sin(Math.PI * (count - 90) / 180));
                lPoint.y = (int) (mPoint.y - +Ball_R * Math.cos(Math.PI * (count - 90) / 180));
                rPoint.x = (int) (mPoint.x- Ball_R* Math.sin(Math.PI * (count + 90) / 180));
                rPoint.y = (int) (mPoint.y - +Ball_R * Math.cos(Math.PI * (count + 90) / 180));
            }

            invalidate();
        }
        return super.onTouchEvent(event);
    }

}
