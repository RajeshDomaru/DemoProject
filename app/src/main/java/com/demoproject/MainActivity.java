package com.demoproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText etRupee;
    private AppCompatTextView tvTotalChocolates;
    private AppCompatButton btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /*Fragment fragment = new FirstFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llMainView, fragment)
//                .addToBackStack(MyFragmentA.class.getSimpleName())
                .commit();*/

        load();

    }

    private void load() {

        initialization();

        setOnClickListener();

    }

    private void initialization() {

        etRupee = findViewById(R.id.etRupee);
        tvTotalChocolates = findViewById(R.id.tvTotalChocolates);
        btnCalculate = findViewById(R.id.btnCalculate);

    }

    private void setOnClickListener() {

        btnCalculate.setOnClickListener(v -> {

            String stringRupee = etRupee.getText().toString();

            if (!stringRupee.equalsIgnoreCase("")) {

                int rupee = Integer.parseInt(stringRupee);

                tvTotalChocolates.setText(String.valueOf(calculateChocolate(rupee)));

            }

        });

    }

    private int calculateChocolate(int rupee) {

        int totalChocolate;

        int chocolateWrapper = totalChocolate = rupee;

        while (0 != (chocolateWrapper / 3)) {

            int chocolateFromWrapper = chocolateWrapper / 3;

            int remainingWrapper = chocolateWrapper % 3;

            totalChocolate += chocolateFromWrapper;

            chocolateWrapper = (chocolateFromWrapper + remainingWrapper);

        }

        return totalChocolate;

    }

}