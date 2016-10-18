package ru.solandme.holidays.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;

import ru.solandme.holidays.R;

public class ApiRepository {

    private SharedPreferences sharedPreferences;

    public ApiRepository(Context context) {
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }


    static private String[] typeCodes = {"National", "Birthday", "Events", "Name day", "Religious"};

    private int[] flags = {R.mipmap.ic_russia, R.mipmap.ic_ukraine, R.mipmap.ic_usa};

    static private ArrayList<Holiday> generateSampleHolidays() {

        ArrayList<Holiday> arrayHolidays = new ArrayList<>();
        Holiday holiday1 = new Holiday(
                "New Year",
                "RU", "31-12-2016",
                "New Year's Day, also called simply New Year's or New Year, is observed on January 1, the first day of the year on the modern Gregorian calendar as well as the Julian calendar.",
                "National");
        Holiday holiday2 = new Holiday(
                "Birthday",
                "RU", "26-03-1981",
                "My birthday",
                "Birthday");

        arrayHolidays.add(holiday1);
        arrayHolidays.add(holiday2);

        return arrayHolidays;
    }

    public static ArrayList<Holiday> getHolidaysByPage(int page) {


        ArrayList<Holiday> holidaysList = new ArrayList<>();
        for (Holiday holiday : generateSampleHolidays()) {
            if (page == Arrays.asList(typeCodes).indexOf(holiday.getTypes()))
                holidaysList.add(holiday);
        }
        return holidaysList;
    }

    public boolean getSettingSplashChkBox() {
        return sharedPreferences.getBoolean("isNeedShowSplash", true);
    }

    public void setSettingSplashChkBow(boolean settingSplashChkBow) {
        sharedPreferences.edit().putBoolean("isNeedShowSplash", settingSplashChkBow).apply();
    }

    public int[] getFlagList() {
        return flags;
    }

    public int getCurrentCountrySelected() {
        return sharedPreferences.getInt("country", 0);
    }

    public void setSettingCurrentCountry(int settingCurrentCountry) {
        sharedPreferences.edit().putInt("country", settingCurrentCountry).apply();
    }
}
