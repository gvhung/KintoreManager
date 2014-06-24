package org.p_taro.kintoremanager.app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dev on 14/06/23.
 * スケジュールテーブル用Dao
 */
public class DBScheduleDao extends DBBaseDao<DBScheduleEntity> implements DBIScheduleDao{
    private static final String TABLE_NAME = "schedule";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_GROUP_ID = "group_id";
    private static final String COLUMN_DATE = "date";
    private static final String[] COLUMNS = { COLUMN_ID,COLUMN_GROUP_ID,COLUMN_DATE, };

    private SQLiteDatabase db;

    protected DBScheduleDao(SQLiteDatabase db) {
        super(db);
    }

    @Override
    protected String getCOLUMN_ID() {
        return COLUMN_ID;
    }

    @Override
    protected String getTABLE_NAME() {
        return TABLE_NAME;
    }

    @Override
    protected String[] getCOLUMNS() {
        return COLUMNS;
    }

    @Override
    protected DBScheduleEntity getAllEntities(Cursor cursor) {
        DBScheduleEntity entity = new DBScheduleEntity();
        entity.setId(cursor.getInt(0));
        entity.setGroupID(cursor.getInt(1));
        entity.setDate(cursor.getString(2));
        return entity;
    }
     /**
     * 特定の日付のデータを取得
     * @param date
     */
    public  DBScheduleEntity findByDate(String date){
        String selection = COLUMN_DATE + "=" + date;
        Cursor cursor = db.query(
                TABLE_NAME,
                COLUMNS,
                selection,
                null,
                null,
                null,
                null
        );
        cursor.moveToNext();
        DBScheduleEntity entity = getAllEntities(cursor);
        return entity;
    }
    @Override
    public long insert(DBScheduleEntity entity) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_GROUP_ID,entity.getGroupID());
        values.put(COLUMN_DATE, entity.getDate());
        return db.insert(TABLE_NAME, null, values);
    }

    @Override
    public int update(DBScheduleEntity entity) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, entity.getDate());
        values.put(COLUMN_GROUP_ID, entity.getGroupID());
        String whereClause = COLUMN_ID + "=" + entity.getId();
        return db.update(TABLE_NAME, values, whereClause, null);
    }


}
