package com.desin.kelala.restkelala.util;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatUtil {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public Date getStringToDate(String stringFromDate) {
        DateFormat formatInput = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        //DateFormat formatInput = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES"));
        Date formatDate = null;
        try {
            formatDate = formatInput.parse(stringFromDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    public static Date getStringToDate(String stringFromDate, String format) {
        DateFormat formatInput = new SimpleDateFormat(format);
        //DateFormat formatInput = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES"));
        Date formatDate = null;
        try {
            formatDate = formatInput.parse(stringFromDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    public static String parseException(Throwable e) {
        StringBuilder result = new StringBuilder();
        while (e != null) {
            result.append(result.length() != 0 ? " > " : "").append(e.getMessage());
            e = e.getCause();
        }
        return result.toString();
    }

    public static String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }
}
