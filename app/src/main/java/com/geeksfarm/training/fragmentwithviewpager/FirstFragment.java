package com.geeksfarm.training.fragmentwithviewpager;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    ListView listView;
    private ArrayList<MenuMakanan.Makanan> dataSet;

    public static FirstFragment newInstance(String text){
        FirstFragment firstFragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString("text",text);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    public void getData(ArrayList<MenuMakanan.Makanan> dataSets){
        this.dataSet = dataSets;
    }

    //private TextView textDatas;
    private ListView lv;

    public void cek(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent next = new Intent(getActivity(), DeskripsiActivity.class);
                next.putExtra("Nama", adapter.getItem(position));
                startActivity(next);
            }
        });
    }

    DaftarMenuAdapter adapter;
    //private TextView textData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_first, container, false);
        adapter = new DaftarMenuAdapter(getActivity(), dataSet);

        lv = rootView.findViewById(R.id.lv_first);
        lv.setAdapter(adapter);
       // cek();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent next = new Intent(getActivity(), DeskripsiActivity.class);
                next.putExtra("Nama", adapter.getItem(position));
                startActivity(next);
                Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_LONG).show();
            }
        });

        /*textData = rootView.findViewById(R.id.text_data);
        textData.setText(getArguments().getString("text"));*/

        return rootView;

    }
}
