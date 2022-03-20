package com.demoproject.fragments;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.demoproject.R;

public class FirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View mainView;

    private EditText etName, etAge;

    private Button btnAdd, btnGoToSecondFragment;

    public FirstFragment() {

    }

    public static FirstFragment newInstance(String param1, String param2) {

        FirstFragment fragment = new FirstFragment();

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

        mainView = inflater.inflate(R.layout.fragment_first, container, false);

        init();

        setOnClickListener();

        return mainView;

    }

    private void init() {

        etName = mainView.findViewById(R.id.etName);

        etAge = mainView.findViewById(R.id.etAge);

        btnAdd = mainView.findViewById(R.id.btnAdd);

        btnGoToSecondFragment = mainView.findViewById(R.id.btnGoToSecondFragment);

    }

    private void setOnClickListener() {

        btnAdd.setOnClickListener(view -> {

            save();

            gotoSecondPage();

        });

        btnGoToSecondFragment.setOnClickListener(view -> {

            gotoSecondPage();

        });

    }

    @SuppressLint("CommitPrefEdits")
    private void save() {

        SharedPreferences.Editor editor = getActivity().getSharedPreferences("StudentDetails", 0).edit();

        String name = etName.getText().toString();
        int age = Integer.parseInt(etAge.getText().toString());

        editor.putString("Name", name);
        editor.putInt("Age", age);

        editor.apply();

    }

    private void gotoSecondPage() {

        Fragment fragment = new SecondFragment();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.llMainView, fragment)
                .commit();

    }

}