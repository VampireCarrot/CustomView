package com.lwd.customview.basic.GameOne;

import android.graphics.Point;

/**
 * User: LWD
 * Date: 2016/12/21
 * Email: 13102169005@163.com
 * Description:
 */

public class RectModl {

    private Point startPoint;
    private Point endPoint;

    public RectModl(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
