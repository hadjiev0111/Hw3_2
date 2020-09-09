package com.example.hw3_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private EditText count1, count2, count3;
    private Button button;
    private double sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        textResult = findViewById(R.id.textResult);
        count1 = findViewById(R.id.count1);
        count2 = findViewById(R.id.count2);
        count3 = findViewById(R.id.count3);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInfo();
            }
        });
    }

    private void getInfo() {
        double c1 = Double.parseDouble(count1.getText().toString());
        double c2 = Double.parseDouble(count2.getText().toString());
        double c3 = Double.parseDouble(count3.getText().toString());

        sum = c1 + c2 * c3;
        String result = Double.toString(sum);
        textResult.setText(result);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("sum", textResult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textResult.setText(savedInstanceState.getString("sum"));
    }
}