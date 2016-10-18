package ru.solandme.holidays;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import ru.solandme.holidays.adapters.CustomSpinnerAdapter;

public class Splashscreen extends AppCompatActivity implements View.OnClickListener, MvpSplash.RequiredViewOps {

    //    SplashPresenter splashPresenter;
    private MvpSplash.ProvidedPresenterOps mPresenter;
    CheckBox chkBoxNeedShowSplash;
    private final StateMaintainer mStateMaintainer =
            new StateMaintainer( getFragmentManager(), MainActivity.class.getName());
    private int currentCountrySelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

//        splashPresenter = new SplashPresenter(this);
//
//        if (!splashPresenter.isNeedShowSplash()) {
//            startMainActivity();
//        }

        initViews();
        setupMVP();
    }

    private void setupMVP() {
        // Check if StateMaintainer has been created
        if (mStateMaintainer.firstTimeIn()) {
            // Create the Presenter
            SplashPresenter presenter = new SplashPresenter(this);
            // Create the Model
            SplashModel model = new SplashModel(presenter);
            // Set Presenter model
            presenter.setModel(model);
            // Add Presenter and Model to StateMaintainer
            mStateMaintainer.put(presenter);
            mStateMaintainer.put(model);

            // Set the Presenter as a interface
            // To limit the communication with it
            mPresenter = presenter;

        }
        // get the Presenter from StateMaintainer
        else {
            // Get the Presenter
            mPresenter = mStateMaintainer.get(SplashPresenter.class.getName());
            // Updated the View in Presenter
            mPresenter.setView(this);
        }
    }

    private void initViews() {

//---------------CheckBox init----------------
        chkBoxNeedShowSplash = (CheckBox) findViewById(R.id.chkBoxDoNotShow);
//        chkBoxNeedShowSplash.setChecked(splashPresenter.isNeedShowSplash());
//        chkBoxNeedShowSplash.setOnClickListener(view -> {
//            splashPresenter.chkBoxChanged(chkBoxNeedShowSplash.isChecked());
//        });

// -------------Spinner init----------------
        Spinner countriesSpinner = (Spinner) findViewById(R.id.countrySpinner);

//        CustomSpinnerAdapter spinnerAdapter = new CustomSpinnerAdapter(
//                getApplicationContext(),
//                splashPresenter.getFlagsList(),
//                getResources().getStringArray(R.array.countries));
//
//        countriesSpinner.setAdapter(spinnerAdapter);
//        countriesSpinner.setSelection(splashPresenter.getCurrentCountrySelected());
//        countriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                currentCountrySelected = position;
//                splashPresenter.currentCountryChanged(position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

//---------------Submit Button init----------------
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(this);
//        submitBtn.setOnClickListener(view -> {
//            splashPresenter.currentCountryChanged(currentCountrySelected);
//            startMainActivity();
//        });
    }



    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void startMainActivity(int currentCountrySelected) {
        Intent intent = new Intent(Splashscreen.this, MainActivity.class);
        intent.putExtra("currentCountry", currentCountrySelected);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitBtn: {
                mPresenter.clickToSubmitBtn(currentCountrySelected);
            }
        }
    }
}
