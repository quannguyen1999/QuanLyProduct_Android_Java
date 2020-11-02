package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class frag03 extends Fragment {
    TextView txtName, txtContent, txtPrice;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag03, container, false);
        txtName = view.findViewById(R.id.txtName);
        txtContent = view.findViewById(R.id.txtContent);
        txtPrice = view.findViewById(R.id.txtPrice);
        return view;
    }


}
