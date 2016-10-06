package com.baekcedar.android.fragmentbasic03;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    public static ArrayList<Data> datas = new ArrayList<>();
    Fragment1 fragment1;
    Fragment2 fragment2;
    public int position =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // 데이터 삽입
        for(int i =1 ; i <= 200 ; i ++){
            Data data = new Data();
            data.title = "Title"+i;
            data.contents = "context"+i;
            datas.add(data);
        }

         fragment1 = new Fragment1();
         fragment2 = new Fragment2();
         setOne();

    }


    // 처음 시작 화면
    public void setOne(){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment,fragment1);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void goFragment2(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment,fragment2);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
