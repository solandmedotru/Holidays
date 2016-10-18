package ru.solandme.holidays;

import ru.solandme.holidays.data.ApiRepository;

public class SplashPresenter {

    Splashscreen activity;
    ApiRepository apiRepository;

    public SplashPresenter(Splashscreen activity) {
        this.activity = activity;
        apiRepository = new ApiRepository(activity);
    }


    public boolean isNeedShowSplash() {
        return apiRepository.getSettingSplashChkBox();
    }

    public void chkBoxChanged(boolean checked) {
        apiRepository.setSettingSplashChkBow(checked);
    }

    public int[] getFlagsList() {
        return apiRepository.getFlagList();
    }

    public int getCurrentCountrySelected() {
        return apiRepository.getCurrentCountrySelected();
    }

    public void currentCountryChanged(int position) {
        apiRepository.setSettingCurrentCountry(position);
    }
}
