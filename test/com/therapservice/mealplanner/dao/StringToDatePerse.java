package com.therapservice.mealplanner.dao;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/24/12
 * Time: 6:56 PM
 */
public class StringToDatePerse {

    @Test
    public void parse() throws ParseException {
        String date = "12/17/2012";

        Date thedate = new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH).parse(date);
        System.out.println(new java.sql.Date(thedate.getTime()));

    }
}
