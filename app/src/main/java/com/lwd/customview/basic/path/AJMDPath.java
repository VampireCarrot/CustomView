package com.lwd.customview.basic.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * User: LWD
 * Date: 2016/12/19
 * Email: 13102169005@163.com
 * Description:
 */

public class AJMDPath extends View {
    Path mPath;
    Paint mPaint;
    private int count = 1;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    AJMDPath.this.invalidate();
                    break;
            }
        }
    };
    public AJMDPath(Context context) {
        super(context);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    count++;
                    try {
                        Thread.sleep(500);

                        if(count<=6145){
                            handler.sendEmptyMessage(0);
                        }else{
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();



    }

    public AJMDPath(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AJMDPath(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);

        float x0=this.getWidth()/2;
        float y0=this.getHeight()/2;
        canvas.drawLine(x0, 0,x0,2*y0,mPaint);
        canvas.drawLine(0, y0,2*x0,y0,mPaint);

        for (int i=0; i<count; i++){
            mPath = new Path();
            mPath.moveTo(x0+(int)Math.round( 0.6*((i-1)*Math.PI/512)*Math.cos((i-1)*Math.PI/512)),
                    y0+(int)Math.round( 0.6*((i-1)*Math.PI/512)*Math.sin((i-1)*Math.PI/512)));
            mPath.lineTo(x0+(int)Math.round( 0.6*(i*Math.PI/512)*Math.cos(i*Math.PI/512)),
                    y0+(int)Math.round( 0.6*(i*Math.PI/512)*Math.sin(i*Math.PI/512)));
        }
        canvas.drawPath(mPath,mPaint);
    }
}
