package com.baekcedar.android.fragmentbasic03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {
    Data data;
    int position;
    public Fragment2( ) {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        data = new Data();
        MainActivity mainActivity = (MainActivity) getActivity();
        data = mainActivity.datas.get(position);
        TextView textTitle = (TextView) container.findViewById(R.id.textTitle);
        textTitle.setText(data.title);
        TextView textContext = (TextView) container.findViewById(R.id.textContext);
        textContext.setText(data.contents);
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

}
