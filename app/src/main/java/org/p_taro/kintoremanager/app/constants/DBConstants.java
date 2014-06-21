package org.p_taro.kintoremanager.app.constants;

/**
 * Created by dev on 2014/06/04.
 */
public class DBConstants {
    private static final String[] tableQuery =  {
            /**
             * メニューグループテーブル
             */
            "Create table menu_group("+
            "_id integer primary key autoincrement,"+
            "group_name text not null"+
            ");",
            /**
             * メニューモジュール
             */
            "Create table menu_module("+
            "group_Id integer," +
            "event text not null,"+
            "weight1 integer," +
            "rep1 integer," +
            "weight2 integer," +
            "rep2 integer," +
            "weight3 integer," +
            "rep3 integer," +
            "weight4 integer," +
            "rep4 integer," +
            "weight5 integer," +
            "rep5 integer," +
            "foreign key(group_id) references menu_group(_id)" +
            ");",
            /*
             スケジュールテーブル
             */
            "create table schedule(" +
            "group_id integer" +
            "date integer," +
            "foreign key(group_id) references menu_group(_id)" +
            ");",
    };




    public static String getTableQuery(Table_Name table){
        int index = table.ordinal();
        return tableQuery[index];
    }
    public enum Table_Name{
        MENU_GROUP,
        MENU_MODULE,
        SCHEDULE,

        MAX,
    }
}
