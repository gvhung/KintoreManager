package org.p_taro.kintoremanager.app.activity;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import org.p_taro.kintoremanager.app.R;
import org.p_taro.kintoremanager.app.database.DataBase;
import org.p_taro.kintoremanager.app.database.DataBaseOpenHelper;
import org.p_taro.kintoremanager.app.date.MyDate;


public class MenuFragment extends BaseFragment {
    private DataBaseOpenHelper helper;
    private SQLiteDatabase db;

    private TextView mDateTextView;
    private ListView mMenuListView;
    private TextView mGrpNameTextView;
    private MyDate mMyDate = new MyDate();
    private Context context;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        findView(v);
        return v;
    }
    private void findView(View view){
        mDateTextView = (TextView)view.findViewById(R.id.date_textview);
        mGrpNameTextView = (TextView)view.findViewById(R.id.grp_name_textview);
        mMenuListView = (ListView)view.findViewById(R.id.menu_listview);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        mDateTextView.setText(mMyDate.getDateToday());
        context = getActivity();
        setMenuList();

        mMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

            }
        });

    }
    private void setMenuList(){
        ArrayAdapter<String> adapter;
        DataBase database = new DataBase(context);
        int id = database.getGroupId(mMyDate.getDateToday());
        if(id > -1){
             // データがある場合はリストに本日のメニューを表示する
            mGrpNameTextView.setText(database.getGroupName(id));
            adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,database.getEvent(id));
        }else{
            // テーブルにレコードが無いときはリストにデータ作成リンクを表示
            String[] strAddMenu = {"メニュー作成..."};
            adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,strAddMenu);
            mGrpNameTextView.setText("");
        }
        mMenuListView.setAdapter(adapter);
    }
}
