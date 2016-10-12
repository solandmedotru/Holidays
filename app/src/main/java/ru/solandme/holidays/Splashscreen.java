package ru.solandme.holidays;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import ru.solandme.holidays.adapters.CustomSpinnerAdapter;

public class Splashscreen extends AppCompatActivity {

    private int[] flags = {R.mipmap.ic_russia, R.mipmap.ic_ukraine, R.mipmap.ic_usa};

    private Context context;

    private int currentCountrySelected;
    private boolean isDontShowSplash;

    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        context = getApplicationContext();

        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
        currentCountrySelected = sharedPreferences.getInt("country", 0);
        isDontShowSplash = sharedPreferences.getBoolean("isDontShowSplash", false);

        if(isDontShowSplash){
            startMainActivity();
        }

        initViews();
    }

    private void initViews() {

//---------------CheckBox init----------------
        final CheckBox chkBoxDoNotShow = (CheckBox) findViewById(R.id.chkBoxDoNotShow);
        chkBoxDoNotShow.setChecked(isDontShowSplash);
        chkBoxDoNotShow.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isDontShowSplash", chkBoxDoNotShow.isChecked()).apply();
        });

// -------------Spinner init----------------
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

//---------------Submit Button init----------------
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("country", currentCountrySelected).apply();

            startMainActivity();
        });
    }

    private void startMainActivity() {
        startActivity(new Intent(Splashscreen.this, MainActivity.class));
        finish();
    }
}
