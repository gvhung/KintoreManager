package org.p_taro.kintoremanager.app.database;

/**
 * Created by dev on 14/06/23.
 */
public class DBScheduleEntity extends DBBaseEntity{
    private int id;
    private int groupID;
    private String date;

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
