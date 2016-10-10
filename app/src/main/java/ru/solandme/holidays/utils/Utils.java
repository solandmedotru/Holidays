package ru.solandme.holidays.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import ru.solandme.holidays.R;

public class Utils {
    private static int sTheme;
    private static SharedPreferences sharedPreferences;

    public final static int THEME_MATERIAL_LIGHT = 0;
    public final static int THEME_MATERIAL_DARK = 1;

    public static void changeToTheme(int theme, Activity activity) {

        sTheme = theme;

        sharedPreferences = activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("theme", sTheme).apply();

        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);

    }

    public static void onActivityCreateSetTheme(Activity activity) {
        sharedPreferences = activity.getSharedPreferences("settings", Context.MODE_PRIVATE);
        sTheme = sharedPreferences.getInt("theme", 0);
        switch (sTheme) {
            default:
            case THEME_MATERIAL_LIGHT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_MATERIAL_DARK:
                activity.setTheme(R.style.AppThemeDark);
                break;
        }
    }
}
