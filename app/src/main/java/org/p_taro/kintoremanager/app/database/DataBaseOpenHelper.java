package org.p_taro.kintoremanager.app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.p_taro.kintoremanager.app.constants.DBConstants;

/**
 * Created by dev on 2014/06/04.
 */
public class DataBaseOpenHelper extends SQLiteOpenHelper {
    public DataBaseOpenHelper(Context con){
        super(con,"kintoreDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
         テーブル作成
         */
        db.execSQL("PRAGMA foreign_keys=true;");
        String sql = DBConstants.getTableQuery(DBConstants.Table_Name.MENU_GROUP);
        db.execSQL(sql);
        sql = DBConstants.getTableQuery(DBConstants.Table_Name.MENU_MODULE);
        db.execSQL(sql);
        sql = DBConstants.getTableQuery(DBConstants.Table_Name.SCHEDULE);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
