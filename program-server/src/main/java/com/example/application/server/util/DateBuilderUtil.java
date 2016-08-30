package com.example.application.server.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateBuilderUtil
 */
@Component
public class DateBuilderUtil {

    public Date convertStringToDate(String dateInString) {
        if (dateInString == null || dateInString.isEmpty()) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            try {
                date = formatter.parse(dateInString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }

    public String convertDateToString(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            return formatter.format(date);
        }
    }
}
