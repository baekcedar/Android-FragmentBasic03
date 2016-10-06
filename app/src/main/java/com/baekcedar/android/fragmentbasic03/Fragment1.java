package com.baekcedar.android.fragmentbasic03;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    ListView listView;
    public Fragment1() {} //생성자

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        listView = (ListView) view.findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //TODO 아이템 클릭시 디테일 화면 이동
                MainActivity main = (MainActivity)getActivity();
                main.position= position;
                main.goFragment2();
            }
        });

        return view;
    }

}
class CustomAdapter extends BaseAdapter { //커스텀 Adapter

    Context context;
    LayoutInflater inflater;

    public CustomAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return MainActivity.datas.size();
    }

    @Override
    public Object getItem(int position) {
        return MainActivity.datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = inflater.inflate(R.layout.fragment_item, null);

        TextView title = (TextView) convertView.findViewById(R.id.textView);
        title.setText(MainActivity.datas.get(position).title);

        return convertView;
    }

}
