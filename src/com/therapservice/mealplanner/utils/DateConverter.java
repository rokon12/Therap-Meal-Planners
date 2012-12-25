package com.therapservice.mealplanner.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/25/12
 * Time: 10:39 AM
 */
public class DateConverter {
    public static Date StringToDateConversion(String date) {
        try {
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
            System.out.println(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }
    private String converUtilDateToSqlDate(java.util.Date utilDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sqlDate = sdf.format(utilDate);
        return sqlDate;
    }

    public static void main(String[] args) {
        StringToDateConversion("2012-12-21");
    }
}
