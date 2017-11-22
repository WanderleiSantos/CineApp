package net.itinajero.app.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static List<String> getNextDays(int count){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date start = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, count);
        Date endDate = calendar.getTime();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(start);
        List<String> nextDays = new ArrayList<String>();
        while (!gregorianCalendar.getTime().after(endDate)){
            Date d = gregorianCalendar.getTime();
            gregorianCalendar.add(Calendar.DATE, 1);
            nextDays.add(simpleDateFormat.format(d));
        }
        return nextDays;
    }
}
