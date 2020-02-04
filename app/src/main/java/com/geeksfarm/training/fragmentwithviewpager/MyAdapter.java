package com.geeksfarm.training.fragmentwithviewpager;

import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentStatePagerAdapter {

    private static ArrayList<String> myTitles;
    private static ArrayList<String> myData;

    private static ArrayList<MenuMakanan> myFoodMenus;

    private static int numOfItems;

    public static MyAdapter newInstance(FragmentManager fragmentManager, ArrayList<String> titles,ArrayList<String> data){
        MyAdapter myAdapter = new MyAdapter(fragmentManager);
        myTitles = titles;
        myData = data;
        numOfItems = titles.size(); // set numOfItems as size of data or titles
        return myAdapter;
    }

    //Overload newInstance() above
    public static MyAdapter newInstance(FragmentManager fragmentManager, ArrayList<MenuMakanan> kumpulanMenuMakanan){
        MyAdapter myAdapter = new MyAdapter(fragmentManager);
        myFoodMenus = kumpulanMenuMakanan;
        numOfItems = kumpulanMenuMakanan.size();
        return myAdapter;
    }




    //constructor
    public MyAdapter(FragmentManager fragmentManager){
        super(fragmentManager); //Deprecated
    }
    public MyAdapter(FragmentManager fragmentManager, ArrayList<MenuMakanan> data){
        super(fragmentManager); //Deprecated
        myFoodMenus = data;
        numOfItems = data.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) { //function
        ArrayList<MenuMakanan.Makanan> data  = myFoodMenus.get(position).getData();

        //FirstFragment firstFragment = new FirstFragment();
        //FirstFragment firstFragment = FirstFragment.newInstance(text); //call newInstance()

        SecondFragment fragment = SecondFragment.newInstance(data);
        //SecondFragment fragment = new SecondFragment();
        //fragment.setData(data);
        return fragment;

    }

    @Override
    public int getCount() {
        return numOfItems;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        try {
            title = myFoodMenus.get(position).getNamaMenu(); // object MenuMakanan menu.getNamaMenu()
        }
        catch (IndexOutOfBoundsException e){
            title = "Apa aja";
        }

        return title;

    }
}
