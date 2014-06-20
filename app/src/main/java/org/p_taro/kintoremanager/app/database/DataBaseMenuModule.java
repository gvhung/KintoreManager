package org.p_taro.kintoremanager.app.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dev on 2014/06/07.
 */
public class DataBaseMenuModule{
    private SQLiteDatabase db;
    private int id;
    private String[] event;
    private int[] weight;
    public DataBaseMenuModule(int id,SQLiteDatabase db){
        this.id = id;
        this.db = db;
    }

    public String[] getEvent(){
        //String[] columns = {"event","weight1","rep1","weight2","rep2","weight3","rep3","weight4","rep4","weight5","rep5"};
        String[] columns = {"event"};
        Cursor cursor = db.query("menu_module",columns,null,null,null,null,"id");
        for(int i = 0; i<cursor.getCount(); i++){
            event[i] = cursor.getString(i);
        }
        return event;
    }
}
