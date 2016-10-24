package ru.solandme.holidays;

import android.content.Context;

public interface MvpSplash {

    interface RequiredViewOps {
        // View operations permitted to Presenter
        Context getAppContext();
        Context getActivityContext();
        void startMainActivity(int currentCountrySelected);
    }

    /**
     * Operations offered to View to communicate with Presenter.
     * Processes user interactions, sends data requests to Model, etc.
     */
    interface ProvidedPresenterOps {
        // Presenter operations permitted to View
        void onDestroy(boolean isChangingConfiguration);
        void clickToSubmitBtn(int currentCountrySelected);
        void setView(RequiredViewOps view);

        int[] getFlagsList();

        int getCurrentCountrySelected();
    }

    /**
     * Required Presenter methods available to Model.
     */
    interface RequiredPresenterOps {
        // Presenter operations permitted to Model
        Context getAppContext();
        Context getActivityContext();
    }

    /**
     * Operations offered to Model to communicate with Presenter
     * Handles all data business logic.
     */
    interface ProvidedModelOps {
        // Model operations permitted to Presenter
        void onDestroy(boolean isChangingConfiguration);
        boolean loadCountryList();
        int getCurrentCountry();

        int[] getFlagsList();

        void setCurrentCountry(int currentCountrySelected);
    }
}
