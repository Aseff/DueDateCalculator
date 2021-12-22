package duedatecalculator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DueDateCalculator {
    
    // The example is checked in order to test the method
    public static void main(String[] args) {
        String end = calculateDueDate("21-12-2021 13:45:57", 15);
        System.out.println(end);
    }
    
    // Add working hours to a date-time string

    public static String calculateDueDate(String submittedDate, int workingHours) {
        Date startDate = parseStringToDate(submittedDate);
        Date endDate = addWorkingHours(startDate, workingHours);
        String formattedEndDate = convertedDate(endDate, "dd-MM-yyyy HH:mm:ss");

        return formattedEndDate;
    }

    // Parse string to date object 
    public static Date parseStringToDate(String dateTimeString) {
        // Format for input
        SimpleDateFormat dateParser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        // Parsing the date
        Date timestamp = null;
        try {
            timestamp = dateParser.parse(dateTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp == null ? new Date() : timestamp;
    }
    
    
    // Add working hours to a Date object
    public static Date addWorkingHours(Date fromDate, int workingHours) {
        Date date = new Date(fromDate.getTime());
        int durationHours = 0;

        while (durationHours < workingHours) {
            date.setHours(date.getHours() + 1);
            if (workingDate(date)) {
                durationHours++;
            }

        }

        return date;
    }

    
    // Determines if the Date is inside working time
    
    public static boolean workingDate(Date date) {
        int[] dates = {1, 2, 3, 4, 5};
        boolean IsInWorkingHours = false;
        boolean IsContain = contains(dates, date.getDay());
        if (IsContain && date.getHours() >= 9 && date.getHours() < 17) {
            IsInWorkingHours = true;
        }

        return IsInWorkingHours;

    }
    
    // Check  whether a date includes in dates array
    public static boolean contains(int[] arr, int key) {
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                found = true;
            }
        }
        return found;
    }

    
    // Convert Date object to string
    
    public static String convertedDate(Date date, String format) {
        
        DateFormat dateFormat = new SimpleDateFormat(format);
        String strDate = dateFormat.format(date);
        return strDate;
        
    }

}
