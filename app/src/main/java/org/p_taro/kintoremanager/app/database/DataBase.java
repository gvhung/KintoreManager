package org.p_taro.kintoremanager.app.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dev on 2014/06/07.
 */
public class DataBase {
    private Context context;
    private DataBaseOpenHelper helper;
    private DataBaseMenuGroup menuGroup;
    private DataBaseSchedule schedule;
    private DataBaseMenuModule menuModule;
    private SQLiteDatabase db;


    public DataBase(Context context){
        this.context = context;
        helper = new DataBaseOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    private String[] readDB(String column,String key){
        return null;
    }
    public String[] getGroupNameAll(int id){
        menuGroup = new DataBaseMenuGroup(id,db);
        return menuGroup.getGroupNameAll();
    }
    public String getGroupName(int id){
        menuGroup = new DataBaseMenuGroup(id,db);
        return menuGroup.getGroupName();
    }

    public int getGroupId(String date){
        schedule = new DataBaseSchedule(date,db);
        return schedule.getGroupID();
    }

    public String[] getEvent(int id){
        menuModule = new DataBaseMenuModule(id,db);
        return menuModule.getEvent();
    }






}
