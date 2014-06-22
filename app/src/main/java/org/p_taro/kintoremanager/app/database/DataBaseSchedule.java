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
        String[] column = {"group_id"};
        Cursor cursor = db.query("schedule",column,null,null,null,null,null);
        if(!cursor.isAfterLast()) {
            id = cursor.getInt(0);
        }else{
<<<<<<< HEAD
            id = 0;
=======
            id = -1;
>>>>>>> issue-sql
        }

        return id;
    }
}
