package com.geeksfarm.training.fragmentwithviewpager;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

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

    private TextView textData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_first, container, false);

        textData = rootView.findViewById(R.id.text_data);
        textData.setText(getArguments().getString("text"));

        return rootView;

    }

}
