package org.p_taro.kintoremanager.app.database;

/**
 * Created by dev on 14/06/23.
 */
public class DBMenuGroupEntity extends DBBaseEntity {
    private int id;
    private String groupName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
