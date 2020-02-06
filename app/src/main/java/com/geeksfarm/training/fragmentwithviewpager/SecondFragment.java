package com.geeksfarm.training.fragmentwithviewpager;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private static final String DATA_PARCELABLE = "daftar_makanan";
    private ArrayList<MenuMakanan.Makanan> data = new ArrayList<>();



    public static SecondFragment newInstance(ArrayList<MenuMakanan.Makanan> daftarMakanan){
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(DATA_PARCELABLE,daftarMakanan);
        fragment.setArguments(args);
        return fragment;
    }
    public SecondFragment() {
        // Required empty public constructor
    }

    public void setData(ArrayList<MenuMakanan.Makanan> daftarMakanan){
        data = daftarMakanan;
    }


    private ListView listView;
    private  DaftarMenuAdapter arrayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        if (getArguments() != null){
            data = getArguments().getParcelableArrayList(DATA_PARCELABLE);
        }
        arrayAdapter = new DaftarMenuAdapter(getContext(),data);
        listView = view.findViewById(R.id.lv_menu_makanan);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent next = new Intent(getActivity(), DeskripsiActivity.class);
                next.putExtra("makanan", arrayAdapter.getItem(position));
                startActivity(next);
                //Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }


}
