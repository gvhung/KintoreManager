package org.p_taro.kintoremanager.app.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dev on 2014/06/07.
 */
public class DataBaseSchedule {
    private String date;
    private int id;
    private SQLiteDatabase db;

    public DataBaseSchedule(String date,SQLiteDatabase db){
        this.db = db;
        this.date = date;
    }
    public int getGroupID(){
        String[] column = {"groupId"};
        Cursor cursor = db.query("schedule",column,null,null,null,null,null);

        id = cursor.getInt(0);
        return id;
    }


}
