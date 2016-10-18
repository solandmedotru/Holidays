package ru.solandme.holidays.data;

public class Holiday {

    private String name;
    private String countryCode;
    private String date;
    private String description;
    private String types;

    public Holiday() {
    }

    public Holiday(String name, String countryCode, String date, String description, String types) {
        this.name = name;
        this.countryCode = countryCode;
        this.date = date;
        this.description = description;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
