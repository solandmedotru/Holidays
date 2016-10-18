package ru.solandme.holidays;

import android.content.Context;
import android.content.SharedPreferences;

public class SplashModel implements MvpSplash.ProvidedModelOps {

    private MvpSplash.RequiredPresenterOps mPresenter;
    private SharedPreferences sharedPreferences;

    public SplashModel(MvpSplash.RequiredPresenterOps presenter) {
        this.mPresenter = presenter;
        sharedPreferences = mPresenter.getAppContext().getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    @Override
    public boolean loadCountryList() {
        return false;
    }

    @Override
    public int getCurrentCountry() {
        return sharedPreferences.getInt("country", 0);
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        if (!isChangingConfiguration) {
            mPresenter = null;
        }
    }
}
