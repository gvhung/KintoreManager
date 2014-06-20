package org.p_taro.kintoremanager.app.constants;

import org.p_taro.kintoremanager.app.activity.BaseFragment;
import org.p_taro.kintoremanager.app.activity.Create1DFragment;
import org.p_taro.kintoremanager.app.activity.DataFragment;
import org.p_taro.kintoremanager.app.activity.GraphFragment;
import org.p_taro.kintoremanager.app.activity.HistoryFragment;
import org.p_taro.kintoremanager.app.activity.MenuFragment;
import org.p_taro.kintoremanager.app.activity.ScheduleFragment;

/**
 * Created by dev on 2014/06/08.
 */
public enum MenuListEnum {
    TODAY_MENU,
    SCHEDULE,
    HISTORY,
    DATA,
    GRAPH,
    CREATE_ONE_DAY;

    // array of fragments
    private static final BaseFragment[] FRAGMENT = {
            new MenuFragment(),
            new ScheduleFragment(),
            new HistoryFragment(),
            new DataFragment(),
            new GraphFragment(),
            new Create1DFragment(),
    };
    // array of menu_list
    private static final String[] MENU_LIST= {
        "本日のメニュー",
        "スケジュール",
        "履歴",
        "データ",
        "グラフ",
        "1日分のメニューを作成",
    };

    @Override
    public String toString(){
       return MENU_LIST[this.ordinal()];
    }

    public static BaseFragment getFragment(int index){
        return FRAGMENT[index];
    }

    public static String[] toStringArray(){
        return MENU_LIST;
    }
}
