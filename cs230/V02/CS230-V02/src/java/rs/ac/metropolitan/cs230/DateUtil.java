package rs.ac.metropolitan.cs230;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    
    public static String getCurrentDate(){
        Date current = new Date();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(current);
    }
    
}
