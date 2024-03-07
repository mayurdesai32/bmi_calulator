package com.desai.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText input_age;
    private EditText  input_weight;
    private EditText  input_feet;
    private EditText input_inches;
    private Button calulateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        setupButtonClickListener();
    }

    private  void setupButtonClickListener() {
        calulateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calulateBmi();
                Toast.makeText(MainActivity.this,"Hello world",Toast.LENGTH_LONG).show();
            }
        });
    }

    private  void calulateBmi() {
        String age=input_age.getText().toString();
        String feet=input_feet.getText().toString();
        String weight=input_weight.getText().toString();
        String inches=input_inches.getText().toString();

        int ageNum= Integer.parseInt(age);
//        int ageNum= Integer.parseInt(age);
//        int ageNum= Integer.parseInt(age);
        int feetNum= Integer.parseInt(feet);
        int weightNum= Integer.parseInt(weight);
        int inchesNum= Integer.parseInt(inches);

        int totalInches = (feetNum* 12)+inchesNum;
        double heightInMeters = totalInches*0.0254;
        double bmi = weightNum /(heightInMeters * heightInMeters);

        String bmiText =String.valueOf(bmi);

        resultText.setText("Bmi Resut= "+bmiText);
    }

    private void findview(){
         resultText= findViewById(R.id.result);
         maleButton = findViewById(R.id.radio_button_male);
         femaleButton = findViewById(R.id.radio_button_female);
          input_age = findViewById(R.id.input_age);
          input_weight = findViewById(R.id.input_weight);
          input_feet = findViewById(R.id.input_feet);
          input_inches = findViewById(R.id.input_inches);
          calulateButton = findViewById(R.id.calulate);

    }
}

