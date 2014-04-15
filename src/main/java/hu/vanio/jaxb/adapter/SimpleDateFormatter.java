package hu.vanio.jaxb.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JAXB date formatter 'yyyy-MM-dd' adapter.
 *
 * @author Pato Istvan <istvan.pato@vanio.hu>
 */
public class SimpleDateFormatter {

    final static public String DATE_FORMAT = "yyyy-MM-dd";

    public static Date parse(String date) {
        Date d = null;
        if (date != null && date.trim().length() > 0) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                d = dateFormat.parse(date);
            } catch (ParseException ex) {
                throw new RuntimeException("Date format must be yyyy-MM-dd");
            }
        }
        return d;
    }

    public static String print(Date date) {
        String result = null;
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            result = dateFormat.format(date);
        }
        return result;
    }
}
