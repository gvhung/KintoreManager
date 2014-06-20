package org.p_taro.kintoremanager.app.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.p_taro.kintoremanager.app.R;

/**
 * Created by dev on 2014/06/08.
 */
public class GraphFragment extends BaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_graph, container, false);
    }
}
