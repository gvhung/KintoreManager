package org.p_taro.kintoremanager.app.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import org.p_taro.kintoremanager.app.R;
import org.p_taro.kintoremanager.app.date.MyDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 14/06/25.
 */
public class MenuGroup {
    private Context context;
    private DataBaseOpenHelper helper;
    private SQLiteDatabase db;
    private DBMenuGroupDao mgDao;
    public MenuGroup(Context context) {
        this.context = context;
        helper = new DataBaseOpenHelper(context);
        db = helper.getWritableDatabase();
        mgDao = new DBMenuGroupDao(db);
    }

    public List<String> getGroupNameList(){
        List<String > gnList = new ArrayList<String>();
        gnList.add(context.getString(R.string.select_group));
        try {
            List<DBMenuGroupEntity> list = mgDao.findAll();
            for(DBMenuGroupEntity entity : list){
                gnList.add( entity.getGroupName());
            }
            gnList.add(context.getString(R.string.create_new_group));
        }catch (SQLException e){

        }
        return gnList;
    }
    public int getGroupIdToday(){
        MyDate date = new MyDate();
        DBScheduleDao sDao = new DBScheduleDao(db);
        DBScheduleEntity sEntity =  sDao.findByDate(date.getDateToday());
        int id = sEntity.getGroupID();
        return id;
    }
}
