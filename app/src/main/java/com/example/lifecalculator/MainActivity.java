package com.example.lifecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calcBttn = (Button) findViewById(R.id.calcBttn);

        calcBttn.setOnClickListener(new View.OnClickListener() {

            @Override @TargetApi(26)
            public void onClick(View view) {
                EditText birthdateTxt = (EditText) findViewById(R.id.birthdateTxt);
                EditText deathdate = (EditText) findViewById(R.id.deathdate);
                EditText livedForYears = (EditText) findViewById(R.id.livedForYears);
                EditText livedForDays = (EditText) findViewById(R.id.livedForDays);
                TextView resultTxt = (TextView) findViewById(R.id.resultTxt);

                // displays their birthday from death date and years lived entered by user (Deathdate and Years/Days are not empty fields)
                if (!(deathdate.getText().toString().isEmpty()) && !(livedForYears.getText().toString().isEmpty()) && !(livedForDays.getText().toString().isEmpty())){
                    LocalDate deathDate = LocalDate.parse(deathdate.getText().toString());
                    int yearsLived = Integer.parseInt(livedForYears.getText().toString());
                    int daysLived = Integer.parseInt(livedForDays.getText().toString());
                    LocalDate foundBirthday = deathDate.minusYears(yearsLived).minusDays(daysLived);
                    resultTxt.setText("Their birthdate is " + foundBirthday.toString());
                }
                //displays how long they lived when given birthdate and deathdate (Birthdate and deathdate are not empty fields)
                else if (!(birthdateTxt.getText().toString().isEmpty()) && !(deathdate.getText().toString().isEmpty())) {
                    LocalDate birthdate = LocalDate.parse(birthdateTxt.getText().toString());
                    LocalDate deathDate = LocalDate.parse(deathdate.getText().toString());

                    long yearsLived = ChronoUnit.YEARS.between(birthdate, deathDate);
                    deathDate = deathDate.minusYears(yearsLived);
                    long daysLived = ChronoUnit.DAYS.between(birthdate, deathDate);

                    resultTxt.setText("They lived for " + yearsLived + " years and " + daysLived + " days");
                }
                //gives death date from years lived and birthdate (Birthdate and yearsLived/DaysLived are not empty fields)
                else if (!(birthdateTxt.getText().toString().isEmpty()) && !(livedForYears.getText().toString().isEmpty()) && !(livedForDays.getText().toString().isEmpty())){
                    int yearsLived = Integer.parseInt(livedForYears.getText().toString());
                    int daysLived = Integer.parseInt(livedForDays.getText().toString());

                    LocalDate birthdate = LocalDate.parse(birthdateTxt.getText().toString());
                    LocalDate deathDate = birthdate.plusYears(yearsLived).plusDays(daysLived);
                    resultTxt.setText("They died on " + deathDate.toString());
                }
            }
        });
    };
}
















