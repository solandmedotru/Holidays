package ru.solandme.holidays;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import ru.solandme.holidays.adapters.CustomSpinnerAdapter;

public class Splashscreen extends AppCompatActivity {

    private int[] flags = {R.mipmap.ic_russia, R.mipmap.ic_usa};

    private Context context;

    private int currentCountrySelected;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        context = getApplicationContext();

        initViews();
    }

    private void initViews() {
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
        currentCountrySelected = sharedPreferences.getInt("country", 0);

        Spinner countriesSpinner = (Spinner) findViewById(R.id.countrySpinner);
        CustomSpinnerAdapter spinnerAdapter = new CustomSpinnerAdapter(context, flags, getResources().getStringArray(R.array.countries));
        countriesSpinner.setAdapter(spinnerAdapter);
        countriesSpinner.setSelection(currentCountrySelected);

        countriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentCountrySelected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("country", currentCountrySelected).apply();

                startActivity(new Intent(Splashscreen.this, MainActivity.class));
                finish();
            }
        });
    }
}
