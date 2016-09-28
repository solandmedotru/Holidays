package ru.solandme.holidays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ru.solandme.holidays.adapters.CustomSpinnerAdapter;

public class Splashscreen extends AppCompatActivity {

    private Spinner countries;
    private int[] flags = {R.mipmap.ic_russia, R.mipmap.ic_usa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        initViews();
    }

    private void initViews() {

        countries = (Spinner) findViewById(R.id.countrySpinner);
        CustomSpinnerAdapter spinnerAdapter = new CustomSpinnerAdapter(getApplicationContext(), flags, getResources().getStringArray(R.array.countries));
        countries.setAdapter(spinnerAdapter);

    }
}
