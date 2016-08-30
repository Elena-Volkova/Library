package com.example.application.server.util;

import org.apache.log4j.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    private static final Logger LOGGER = Logger.getLogger(DateUtil.class);

    private static DateUtil instance;

    private DateUtil() {
    }

    public static DateUtil getBuilderInstance() {
        if (instance == null) {
            instance = new DateUtil();
        }
        return instance;
    }

    public XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            LOGGER.info(ex.getMessage());
        }
        return xmlCalendar;
    }

    public Date toDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }
}