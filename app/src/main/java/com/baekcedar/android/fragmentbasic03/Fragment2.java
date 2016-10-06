package com.baekcedar.android.fragmentbasic03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {


    Data data;
    TextView textTitle;
    TextView textContents;


    @Override
    public void onStart() {
        super.onStart();
        MainActivity main = (MainActivity)getActivity();
        data = MainActivity.datas.get(main.position); //datas 는 static
        textContents.setText(data.contents);
        textTitle.setText(data.title);

    }

    public Fragment2() {//생서자
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

         textTitle = (TextView) view.findViewById(R.id.textTitle);
         textContents = (TextView) view.findViewById(R.id.textContents);

        return view;
    }


}
