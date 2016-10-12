package ru.solandme.holidays.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ru.solandme.holidays.Holiday;

public class ApiRepository {

    static private String[] typeCodes = {"National", "Birthday", "Events", "Name day", "Religious"};

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
}
