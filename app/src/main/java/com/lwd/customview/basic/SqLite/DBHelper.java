package com.lwd.customview.basic.SqLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //数据库名
    public static final String DB_NAME = "CUST.db";
    //表名
    public static final String TABLE_NAME_LEFT = "MenuLeft";

    public static final String TABLE_LEFT ="CREATE TABLE "+TABLE_NAME_LEFT+"(" +
            "_Id             TEXT     NOT NULL," +
            "_Name           TEXT    NOT NULL"+
            ");";

    public static final String TABLE_NAME_RIGHT = "MenuRight";

    public static final String TABLE_RIGHT ="CREATE TABLE "+TABLE_NAME_RIGHT+"(" +
            "_Id             TEXT     NOT NULL," +
            "_Name           TEXT    NOT NULL," +
            "_CurrentNum     TEXT     NOT NULL," +
            "_TotalNum       TEXT     NOT NULL" +
            ");";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    /**
     * 当数据库首次创建时执行该方法，一般将创建表等初始化操作放在该方法中执行.
     * 重写onCreate方法，调用execSQL方法创建表
     * */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_LEFT);
        db.execSQL(TABLE_RIGHT);
    }

    /**
     * 当打开数据库时传入的版本号与当前的版本号不同时会调用该方法
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
