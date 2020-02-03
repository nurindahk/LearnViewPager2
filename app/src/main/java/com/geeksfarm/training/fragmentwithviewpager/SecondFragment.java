package com.geeksfarm.training.fragmentwithviewpager;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {



    public SecondFragment() {
        // Required empty public constructor
    }

    private ArrayList<String> itemList = new ArrayList<>();
    private ListView listView;
    private  ArrayAdapter<String> arrayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        generateData();
        listView = view.findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.list_view_content_second_fragment,R.id.textData,itemList);
        listView.setAdapter(arrayAdapter);
        return view;
    }

    private void generateData(){
        itemList.add("Item 1");
        itemList.add("Item 2");
        itemList.add("Item 3");
        itemList.add("Item 4");


    }

}
