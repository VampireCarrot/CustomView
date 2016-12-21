package com.lwd.customview.basic.GameOne;



import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: LWD
 * Date: 2016/12/21
 * Email: 13102169005@163.com
 * Description:
 */

public class RandomRect {

    public static  Point getRandomRect(){

        Point second = new Point();

            // 每次的随机数不同
            Random rand = new Random();
            second.x = Math.abs(rand.nextInt())%400+350;
            second.y= Math.abs(rand.nextInt())%100+80;

        return second;
    }


}
