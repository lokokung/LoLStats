package util;

import java.text.DateFormat;
import java.util.Date;

public class DateTimeConverter {
    public String getDate(long date){
        Date creation = new Date(date);
        return DateFormat.getDateInstance().format(creation)
                .toUpperCase();
    }
    
    public String getDuration(long secs){
        int durationH = (int) (secs / 3600);
        secs %= 3600;
        int durationM = (int) (secs / 60);
        secs %= 60;
        String duration = String.format("%02d:%02d", durationM, secs);
        if (durationH > 0) {
            duration = durationH + ":" + duration;
        }
        return duration;
    }
}
