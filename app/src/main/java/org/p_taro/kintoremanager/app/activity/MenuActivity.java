package org.p_taro.kintoremanager.app.activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;


import org.p_taro.kintoremanager.app.R;
import org.p_taro.kintoremanager.app.constants.MenuListEnum;

public class MenuActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MenuFragment fragment = new MenuFragment();
       FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.content_frame,fragment,"menu");
        transaction.commit();

        getActionBar().setTitle(MenuListEnum.TODAY_MENU.toString());

    }




}
