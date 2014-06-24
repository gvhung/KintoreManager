package org.p_taro.kintoremanager.app.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 14/06/24.
 * super abstract dao class
 */
public abstract class DBBaseDao <T>implements DBIDao<T> {
    private SQLiteDatabase db;

    @Override
    public T findById(int id) {
        String selection = getCOLUMN_ID() + "=" + id;
        Cursor cursor = db.query(
                getTABLE_NAME(),
                getCOLUMNS(),
                selection,
                null,
                null,
                null,
                null
        );
        cursor.moveToNext();
        T entity = getAllEntities(cursor);
        return entity;
    }

    protected DBBaseDao(SQLiteDatabase db) {
        this.db = db;
    }

    /**
     * ID定数を取得
     * @return
     */
    protected abstract String getCOLUMN_ID();

    /**
     * テーブル名定数を取得
     * @return
     */
    protected abstract  String getTABLE_NAME();

    /**
     * カラム定数配列を取得
     * @return
     */
    protected abstract  String[] getCOLUMNS();
    protected abstract  T getAllEntities(Cursor cursor);
    public  List<T> findAll(){
        List<T> entityList = new ArrayList<T>();
        Cursor cursor = db.query(
                getTABLE_NAME(),
                getCOLUMNS(),
                null,
                null,
                null,
                null,
                getCOLUMN_ID()
        );
        while(cursor.moveToNext()){
            T entity = getAllEntities(cursor);
            entityList.add(entity);
        }
        return entityList;
    }
    @Override
    public abstract long insert(T entity) ;
    @Override
    public abstract int update(T entity);
    @Override
    public int delete(int id) {
        String whereClause = getCOLUMN_ID() + "=" + id;
        return db.delete(getTABLE_NAME(),whereClause,null);
    }

}
