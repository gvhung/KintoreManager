package org.p_taro.kintoremanager.app.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.p_taro.kintoremanager.app.R;
import org.p_taro.kintoremanager.app.database.MenuGroup;
import org.p_taro.kintoremanager.app.date.MyDate;

import java.util.List;


public class MenuFragment extends BaseFragment {

    private TextView mDateTextView;
    private ListView mMenuListView;
    private Spinner mGrpNameSpinner;
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

    private void findView(View view) {
        mDateTextView = (TextView) view.findViewById(R.id.date_textview);
        mGrpNameSpinner = (Spinner) view.findViewById(R.id.grp_name_spinner);
        mMenuListView = (ListView) view.findViewById(R.id.menu_listview);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDateTextView.setText(mMyDate.getDateToday());
        context = getActivity();
        setMenuList();

        mMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConfirmDialogFragment dialog = new ConfirmDialogFragment();
                dialog.show(getFragmentManager(), "test");

            }
        });

    }

    private void setMenuList() {
        ArrayAdapter<String> adapter;
        ArrayAdapter<String> grpNameAdapter;
        MenuGroup mgn = new MenuGroup(getActivity());
        List<String > grpNameList = mgn.getGroupNameList();
        grpNameAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, grpNameList);
        mGrpNameSpinner.setAdapter(grpNameAdapter);
    }
}
