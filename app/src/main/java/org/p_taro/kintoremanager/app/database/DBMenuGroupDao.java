package org.p_taro.kintoremanager.app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dev on 14/06/23.
 */
public class DBMenuGroupDao extends DBBaseDao<DBMenuGroupEntity> implements DBIMenuGroupDao {
    private static final String TABLE_NAME = "menu_group";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_GROUP_NAME = "group_name";
    private static final String[] COLUMNS = {COLUMN_ID,COLUMN_GROUP_NAME};

    private SQLiteDatabase db;

    /**
     * コンストラクタ
     * @param db
     */
    public DBMenuGroupDao(SQLiteDatabase db) {
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
    protected DBMenuGroupEntity getAllEntities(Cursor cursor) {
        DBMenuGroupEntity entity = new DBMenuGroupEntity();
        entity.setId(cursor.getInt(0));
        entity.setGroupName(cursor.getString(1));
        return entity;
    }

    /**
     * 特定グループ名からデータ取得
     * @param name
     * @return
     */
    public DBMenuGroupEntity findByGroupName(String name){
        String selection = COLUMN_GROUP_NAME + "=" + name;
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
        DBMenuGroupEntity entity = getAllEntities(cursor);
        return entity;
    }

    @Override
    public long insert(DBMenuGroupEntity entity) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_GROUP_NAME, entity.getGroupName());
        return db.insert(TABLE_NAME, null, values);
    }
    /**
     * データの更新
     * @param entity
     * @return
     */
    @Override
    public int update(DBMenuGroupEntity entity) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_GROUP_NAME, entity.getGroupName());
        String whereClause = COLUMN_ID + "=" + entity.getId();
        return db.update(TABLE_NAME, values, whereClause, null);
    }
}
