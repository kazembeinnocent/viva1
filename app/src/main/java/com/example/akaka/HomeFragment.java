package com.example.akaka;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class HomeFragment extends Fragment{
CardView cardView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

       cardView = (CardView) view.findViewById(R.id.nkhani1);
       cardView.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
             startActivity(new Intent(getActivity(),stories.class));
          }
        });
        return view;

    }

}

