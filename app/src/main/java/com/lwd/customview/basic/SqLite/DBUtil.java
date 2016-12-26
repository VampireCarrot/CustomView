package com.lwd.customview.basic.SqLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;


import java.util.ArrayList;
import java.util.List;


public class DBUtil {
    private SQLiteDatabase db;
    private Context context;

    public DBUtil(Context context) {
        this.context = context;
    }

    private void connDB() {
        if (null == db) {
            db = new DBHelper(context).getWritableDatabase();
        }
    }

    private void closeDB() {
        if (null != db) {
            db.close();
            db = null;
        }
    }


    /**
     * 增加左边菜单
     * @param menuLeft
     */
    public void InsertLeft(MenuLeft menuLeft){
        connDB();
        String sql = "INSERT INTO "+DBHelper.TABLE_NAME_LEFT+" (" +
                "_Id," +
                "_Name" +
                ") VALUES(?,?)";

        db.beginTransaction();
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindString(1, menuLeft.get_Id());
        stmt.bindString(2, menuLeft.get_Name());
        stmt.execute();
        stmt.clearBindings();
        db.setTransactionSuccessful();
        db.endTransaction();
        closeDB();
    }

    /**
     * 根据ID查找左边菜单
     * @param param
     * @return
     */
    public MenuLeft SelectLeft(String[] param){
        connDB();
        String sql = "select * from "+DBHelper.TABLE_NAME_LEFT+" where _id=?";
        Cursor cursor = db.rawQuery(sql,param);
        if (cursor == null) {
            return null;
        }
        MenuLeft menuLeft = null;
        if (cursor.moveToFirst()) {
            menuLeft = new MenuLeft(cursor.getString(0), cursor.getString(1));
        }
        cursor.close();
        closeDB();

     return menuLeft;
    }
    /**
     * 查找所有左边菜单
     *
     */
    public List<MenuLeft> GetAllLeft(){
        connDB();
        String sql = "SELECT * FROM " + DBHelper.TABLE_NAME_LEFT;
        Cursor cursor = db.rawQuery(sql, null);
        List<MenuLeft> data = new ArrayList<MenuLeft>();
        while (cursor.moveToNext()) {
            MenuLeft menuLeft = new MenuLeft(cursor.getString(0), cursor.getString(1));
            data.add(menuLeft);
        }
        cursor.close();
        closeDB();
        return data;
    }
    /**
     * 增加右边菜单
     * @param menuRight
     */
    public void InsertRight(MenuRight menuRight){
        connDB();
        String sql = "INSERT INTO "+DBHelper.TABLE_NAME_RIGHT+" (" +
                "_Id ," +
                "_Name," +
                "_CurrentNum," +
                "_TotalNum" +
                ") VALUES(?,?,?,?);";
        db.beginTransaction();
        SQLiteStatement stmt = db.compileStatement(sql);
        stmt.bindString(1, menuRight.get_ID());
        stmt.bindString(2, menuRight.get_Name());
        stmt.bindString(3, menuRight.get_CurrentNum());
        stmt.bindString(4, menuRight.get_TotalNum());
        stmt.execute();
        stmt.clearBindings();
        db.setTransactionSuccessful();
        db.endTransaction();
        closeDB();
    }
    /**
     * 根据ID查找右边菜单
     * @param param
     * @return
     */
    public MenuRight SelectRight(String[] param){
        connDB();
        String sql = "select * from "+DBHelper.TABLE_NAME_RIGHT+" where _id=?";
        Cursor cursor = db.rawQuery(sql,param);
        if (cursor == null) {
            return null;
        }
        MenuRight menuRight = null;
        if (cursor.moveToFirst()) {
            menuRight = new MenuRight(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        cursor.close();
        closeDB();
        return menuRight;
    }
    /**
     * 查找所有右边边菜单
     *
     */
    public List<MenuRight> GetAllRight(){
        connDB();
        String sql = "SELECT * FROM " + DBHelper.TABLE_NAME_RIGHT;
        Cursor cursor = db.rawQuery(sql, null);
        List<MenuRight> data = new ArrayList<MenuRight>();
        while (cursor.moveToNext()) {
            MenuRight menuLeft = new MenuRight(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            data.add(menuLeft);
        }
        cursor.close();
        closeDB();
        return data;
    }

}













