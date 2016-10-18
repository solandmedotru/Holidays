package ru.solandme.holidays;

import android.content.Context;

import java.lang.ref.WeakReference;

public class SplashPresenter implements MvpSplash.ProvidedPresenterOps, MvpSplash.RequiredPresenterOps {

    private WeakReference<MvpSplash.RequiredViewOps> mView;
    // Model reference
    private MvpSplash.ProvidedModelOps mModel;


    public SplashPresenter(MvpSplash.RequiredViewOps view) {
        this.mView = new WeakReference<>(view);
    }

    private MvpSplash.RequiredViewOps getView() throws NullPointerException{
        if ( mView != null )
            return mView.get();
        else
            throw new NullPointerException("View is unavailable");
    }

    //    Splashscreen activity;
//    ApiRepository apiRepository;
//
//    public SplashPresenter(Splashscreen activity) {
//        this.activity = activity;
//        apiRepository = new ApiRepository(activity);
//    }
//
//
//    public boolean isNeedShowSplash() {
//        return apiRepository.getSettingSplashChkBox();
//    }
//
//    public void chkBoxChanged(boolean checked) {
//        apiRepository.setSettingSplashChkBow(checked);
//    }
//
//    public int[] getFlagsList() {
//        return apiRepository.getFlagList();
//    }
//
//    public int getCurrentCountrySelected() {
//        return apiRepository.getCurrentCountrySelected();
//    }
//
//    public void currentCountryChanged(int position) {
//        apiRepository.setSettingCurrentCountry(position);
//    }

    @Override
    public void clickToSubmitBtn(int currentCountrySelected) {

        getView().startMainActivity(currentCountrySelected);

    }

    @Override
    public Context getAppContext() {
        try {
            return getView().getAppContext();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Context getActivityContext() {
        try {
            return getView().getActivityContext();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        // View show be null every time onDestroy is called
        mView = null;
        // Inform Model about the event
        mModel.onDestroy(isChangingConfiguration);
        // Activity destroyed
        if ( !isChangingConfiguration ) {
            // Nulls Model when the Activity destruction is permanent
            mModel = null;
        }
    }
    @Override
    public void setView(MvpSplash.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    public void setModel(MvpSplash.ProvidedModelOps model) {
        mModel = model;
    }
}
