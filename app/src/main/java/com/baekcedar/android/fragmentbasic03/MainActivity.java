package com.baekcedar.android.fragmentbasic03;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Data> datas = new ArrayList<>();

    Fragment1 fragment1;
    Fragment2 fragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1   = new Fragment1();
        fragment2   = new Fragment2();
        setOne();

        // 데이터 삽입
        for(int i =1 ; i <= 20 ; i ++){
            Data data = new Data();
            data.title = "Title"+i;
            data.contents = "context"+i;
            datas.add(data);
        }







    }
    public void setOne(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment, fragment1);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void goFragment1(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        transaction.replace(R.id.fragment, fragment1);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void goFragment2(){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.fragment, fragment2);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
