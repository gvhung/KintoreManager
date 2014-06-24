package org.p_taro.kintoremanager.app.database;


import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.p_taro.kintoremanager.app.R;

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
    public String[] getGroupNameAll(){
        String[] column = {"group_name"};
        Cursor cursor = db.query("menu_group",column,null,null,null,null,null);
        cursor.moveToFirst();
        String[] list = new String[cursor.getCount()];
        for(int i = 0;i < list.length;i++){
            list[i] = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }
    public String getGroupName(){
        String[] column = {"group_name"};
        String where = "_id=?";
        String param[] ={ String.valueOf(id)};

        Cursor cursor = db.query("menu_group",column,where,param,null,null,null);
        if(!cursor.isAfterLast()) {
            groupName = cursor.getString(0);
        }else{
            groupName ="";
        }
        cursor.close();
        return groupName;
    }
}
