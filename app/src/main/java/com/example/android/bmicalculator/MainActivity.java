package com.example.android.bmicalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float height;
    private float weight;
    private float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button computeButton = (Button) findViewById(R.id.compute_button);
        final EditText heightValue = (EditText) findViewById(R.id.height);
        final EditText weightValue = (EditText) findViewById(R.id.weight);
        final TextView result = (TextView) findViewById(R.id.result);

        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (heightValue.getText().length() > 0
                        && weightValue.getText().length() > 0) {
                    height = Float.parseFloat(heightValue.getText().toString());
                    weight = Float.parseFloat(weightValue.getText().toString());
                    bmi = calculateBMI(height, weight);

                    if (bmi < 16) {
                        result.setText("Your BMI: " + bmi + " (Severely underweight)");
                    } else if (bmi < 18.5) {
                        result.setText("Your BMI: " + bmi + " (Underweight)");
                    } else if (bmi < 25) {
                        result.setText("Your BMI: " + bmi + " (Normal)");
                    } else if (bmi < 30) {
                        result.setText("Your BMI: " + bmi + " (Overweight)");
                    } else {
                        result.setText("Your BMI: " + bmi + " (Obese)");
                    }
                }
            }
        });

    }

    private float calculateBMI(float height, float weight) {
        height = height / 100;
        return weight / (height * height);
    }
}
