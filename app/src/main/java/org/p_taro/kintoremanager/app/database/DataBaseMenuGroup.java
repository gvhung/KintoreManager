package org.p_taro.kintoremanager.app.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dev on 2014/06/07.
 */
public class DataBaseMenuGroup {
    private int id;
    private String groupName;
    private SQLiteDatabase db;


    public DataBaseMenuGroup(int id,SQLiteDatabase db){
        this.id = id;
        this.db = db;

    }
    public String getGroupName(){
        String[] column = {"group_name"};
        Cursor cursor = db.query("menu_group",column,null,null,null,null,null);
        if(!cursor.isAfterLast()) {
            groupName = cursor.getString(0);
        }else{
            groupName ="";
        }
        return groupName;
    }
}
