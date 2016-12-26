package com.lwd.customview.basic.SqLite;

/**
 * User: LWD
 * Date: 2016/12/26
 * Email: 13102169005@163.com
 * Description:
 */

public class MenuRight {
    private String _ID; //右边菜单
    private String _Name; //右边菜单名称
    private String _CurrentNum; // 当前数量
    private String _TotalNum; //商品上限

    public MenuRight() {
    }

    public MenuRight(String _ID, String _Name, String _CurrentNum, String _TotalNum) {
        this._ID = _ID;
        this._Name = _Name;
        this._CurrentNum = _CurrentNum;
        this._TotalNum = _TotalNum;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public String get_CurrentNum() {
        return _CurrentNum;
    }

    public void set_CurrentNum(String _CurrentNum) {
        this._CurrentNum = _CurrentNum;
    }

    public String get_TotalNum() {
        return _TotalNum;
    }

    public void set_TotalNum(String _TotalNum) {
        this._TotalNum = _TotalNum;
    }
}
