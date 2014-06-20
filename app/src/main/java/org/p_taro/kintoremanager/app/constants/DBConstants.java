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
            //"foreign key(groupId) references menu_group(_id)" +
            "groupId integer," +
            "id integer primary key autoincrement," +
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
            "rep5 integer" +
            ");",
            /*
             スケジュールテーブル
             */
            "create table schedule(" +
            "date integer," +
            "foreign key(groupId) references menu_group(_id)" +
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
