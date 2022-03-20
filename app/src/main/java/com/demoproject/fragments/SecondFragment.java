package com.demoproject.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.demoproject.R;

public class SecondFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView tvName, tvAge;

    private Button btnGoToFirstFragment;

    private View mainView;

    public SecondFragment() {

    }

    public static SecondFragment newInstance(String param1, String param2) {

        SecondFragment fragment = new SecondFragment();

        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);

        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);

            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_second, container, false);

        init();

        setOnClickListener();

        displayValues();

        return mainView;

    }

    private void init() {

        tvName = mainView.findViewById(R.id.tvName);

        tvAge = mainView.findViewById(R.id.tvAge);

        btnGoToFirstFragment = mainView.findViewById(R.id.btnGoToFirstFragment);

    }

    private void setOnClickListener() {

        btnGoToFirstFragment.setOnClickListener(view -> {

            Fragment fragment = new FirstFragment();

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.llMainView, fragment)
                    .commit();

        });

    }

    private void displayValues() {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("StudentDetails", 0);

        String name = sharedPreferences.getString("Name", "");
        int age = sharedPreferences.getInt("Age", 0);

        tvName.setText(name);
        tvAge.setText(String.valueOf(age));

    }

}