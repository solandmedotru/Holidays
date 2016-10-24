package ru.solandme.holidays;

import android.content.Context;
import android.content.SharedPreferences;

public class SplashModel implements MvpSplash.ProvidedModelOps {

    private MvpSplash.RequiredPresenterOps mPresenter;
    private SharedPreferences sharedPreferences;
    private int[] flags = {R.mipmap.ic_russia, R.mipmap.ic_ukraine, R.mipmap.ic_usa};

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
        return sharedPreferences.getInt("currentCountry", 0);
    }

    @Override
    public int[] getFlagsList() {
        return flags;
    }

    @Override
    public void setCurrentCountry(int currentCountrySelected) {
        sharedPreferences.edit().putInt("currentCountry", currentCountrySelected).apply();
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        if (!isChangingConfiguration) {
            mPresenter = null;
        }
    }
}
