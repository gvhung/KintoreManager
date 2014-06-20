package org.p_taro.kintoremanager.app.activity;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.p_taro.kintoremanager.app.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DataFragment extends BaseFragment {


    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }


}
