package valkyrie.enigma.enigmaplus.Controller;




import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class elapsedTime {    

 public String duration(String date) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        //formatting question date in to year moth day format;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        //generating and preformatting today's date 
        Calendar currentDate = Calendar.getInstance(); //Get the current date
       // SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //format it as per your requirement
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateNow = formatter.format(currentDate.getTime());
        // System.out.println("Now the date is :=>  " + dateNow);
        //formatting today's date
        int currentYear = Integer.parseInt(dateNow.substring(0, 4));
        int currentMonth = Integer.parseInt(dateNow.substring(5, 7));
        int currentDay = Integer.parseInt(dateNow.substring(8, 10));
        //System.out.println("current month " + currentMonth);

        //calculating the difference between days
        start.set(year, month, day);
        end.set(currentYear, currentMonth, currentDay);
        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        DateFormat dateFormat = DateFormat.getDateInstance();
        // System.out.println("The difference between "
        //         + dateFormat.format(startDate) + " and "
        //        + dateFormat.format(endDate) + " is "
        //      + diffDays + " days.");

        if (diffDays != 0) {
            return Long.toString(diffDays) + " days ago";
        } else if (diffDays == 0) {
            return "today";
        } else {
            return Long.toString(diffDays) + " day ago";
        }
    }
}