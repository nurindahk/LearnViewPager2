package com.geeksfarm.training.fragmentwithviewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentStatePagerAdapter {

    private static ArrayList<String> myTitles;
    private static ArrayList<String> myData;


    private static int numOfItems;

    public static MyAdapter newInstance(FragmentManager fragmentManager, ArrayList<String> titles,ArrayList<String> data){
        MyAdapter myAdapter = new MyAdapter(fragmentManager);
        myTitles = titles;
        myData = data;
        numOfItems = data.size(); // set numOfItems as size of data or titles
        return myAdapter;
    }




    //constructor
    public MyAdapter(FragmentManager fragmentManager){
        super(fragmentManager); //Deprecated
    }

    @NonNull
    @Override
    public Fragment getItem(int position) { //function
        String text = myData.get(position);

        //FirstFragment firstFragment = new FirstFragment();
        FirstFragment firstFragment = FirstFragment.newInstance(text); //call newInstance()

        return firstFragment;

    }

    @Override
    public int getCount() {
        return numOfItems;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = myTitles.get(position);
        return title;

    }
}
