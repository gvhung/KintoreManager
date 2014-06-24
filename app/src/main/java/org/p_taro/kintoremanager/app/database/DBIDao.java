package org.p_taro.kintoremanager.app.database;

import android.database.Cursor;

import java.util.List;

/**
 * Created by dev on 14/06/24.
 */
// super dao interface
public interface DBIDao<T>{
    /**
     * 全データ取得
     * @retrun
     */
    public List<T> findAll();

    /**
     * IDでデータを取得
     */
    public T findById(int id);
    /**
     * データの登録
     * @param entity
     * @return
     */
    public long insert(T entity);

    /**
     * データの更新
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * データの削除
     * @param id
     * @return
     */
    public int delete(int id);
}
