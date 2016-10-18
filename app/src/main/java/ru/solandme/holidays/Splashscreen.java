package ru.solandme.holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import ru.solandme.holidays.adapters.CustomSpinnerAdapter;

public class Splashscreen extends AppCompatActivity {

    SplashPresenter splashPresenter;
    private int currentCountrySelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        splashPresenter = new SplashPresenter(this);

        if(!splashPresenter.isNeedShowSplash()){
            startMainActivity();
        }

        initViews();
    }

    private void initViews() {

//---------------CheckBox init----------------
        CheckBox chkBoxNeedShowSplash = (CheckBox) findViewById(R.id.chkBoxDoNotShow);
        chkBoxNeedShowSplash.setChecked(splashPresenter.isNeedShowSplash());
        chkBoxNeedShowSplash.setOnClickListener(view -> {
            splashPresenter.chkBoxChanged(chkBoxNeedShowSplash.isChecked());
        });

// -------------Spinner init----------------
        Spinner countriesSpinner = (Spinner) findViewById(R.id.countrySpinner);
        CustomSpinnerAdapter spinnerAdapter = new CustomSpinnerAdapter(getApplicationContext(), splashPresenter.getFlagsList(), getResources().getStringArray(R.array.countries));
        countriesSpinner.setAdapter(spinnerAdapter);
        countriesSpinner.setSelection(splashPresenter.getCurrentCountrySelected());
        countriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentCountrySelected = position;
                splashPresenter.currentCountryChanged(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//---------------Submit Button init----------------
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(view -> {
            splashPresenter.currentCountryChanged(currentCountrySelected);
            startMainActivity();
        });
    }

    private void startMainActivity() {
        startActivity(new Intent(Splashscreen.this, MainActivity.class));
        finish();
    }
}
