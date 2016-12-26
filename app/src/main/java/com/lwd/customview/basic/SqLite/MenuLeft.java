package com.lwd.customview.basic.SqLite;

/**
 * User: LWD
 * Date: 2016/12/26
 * Email: 13102169005@163.com
 * Description: 左边菜单栏
 */

public class MenuLeft {
    private String _Id ; //菜单ID
    private String _Name;//左边菜单名称

    public MenuLeft() {
    }

    public MenuLeft(String _Id, String _Name) {
        this._Id = _Id;
        this._Name = _Name;
    }

    public String get_Id() {
        return _Id;
    }

    public void set_Id(String _Id) {
        this._Id = _Id;
    }

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }
}
