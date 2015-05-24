/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valkyrie.enigma.enigmaplus.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Thushan
 */
public class ElapsedTimeFinder {

    
     public static String getElapsedTime(Date dateTime) throws ParseException {
   // Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2010-07-14 09:00:02");
   // String time = new SimpleDateFormat("H:mm").format(date);
    
    StringBuffer sb = new StringBuffer();
    Date current = Calendar.getInstance().getTime();
    long diffInSeconds = (current.getTime() - dateTime.getTime()) / 1000;

    /*long diff[] = new long[]{0, 0, 0, 0};
    /* sec *  diff[3] = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
    /* min *  diff[2] = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds;
    /* hours *  diff[1] = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24 : diffInSeconds;
    /* days * diff[0] = (diffInSeconds = (diffInSeconds / 24));
     */
    long sec = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
    long min = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds;
    long hrs = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24 : diffInSeconds;
    long days = (diffInSeconds = (diffInSeconds / 24)) >= 30 ? diffInSeconds % 30 : diffInSeconds;
    long months = (diffInSeconds = (diffInSeconds / 30)) >= 12 ? diffInSeconds % 12 : diffInSeconds;
    long years = (diffInSeconds = (diffInSeconds / 12));

    if (years > 0) {
        if (years == 1) {
            sb.append("a year");
        } else {
            sb.append(years + " years");
        }
        if (years <= 6 && months > 0) {
            if (months == 1) {
                sb.append(" and a month");
            } else {
                sb.append(" and " + months + " months");
            }
        }
    } else if (months > 0) {
        if (months == 1) {
            sb.append("a month");
        } else {
            sb.append(months + " months");
        }
        if (months <= 6 && days > 0) {
            if (days == 1) {
                sb.append(" and a day");
            } else {
                sb.append(" and " + days + " days");
            }
        }
    } else if (days > 0) {
        if (days == 1) {
            sb.append("a day");
        } else {
            sb.append(days + " days");
        }
        if (days <= 3 && hrs > 0) {
            if (hrs == 1) {
                sb.append(" and an hour");
            } else {
                sb.append(" and " + hrs + " hours");
            }
        }
    } else if (hrs > 0) {
        if (hrs == 1) {
            sb.append("an hour");
        } else {
            sb.append(hrs + " hours");
        }
        if (min > 1) {
            sb.append(" and " + min + " minutes");
        }
    } else if (min > 0) {
        if (min == 1) {
            sb.append("a minute");
        } else {
            sb.append(min + " minutes");
        }
        if (sec > 1) {
            sb.append(" and " + sec + " seconds");
        }
    } else {
        if (sec <= 1) {
            sb.append("about a second");
        } else {
            sb.append("about " + sec + " seconds");
        }
    }

    sb.append(" ago");


    /*String result = new String(String.format(
    "%d day%s, %d hour%s, %d minute%s, %d second%s ago",
    diff[0],
    diff[0] > 1 ? "s" : "",
    diff[1],
    diff[1] > 1 ? "s" : "",
    diff[2],
    diff[2] > 1 ? "s" : "",
    diff[3],
    diff[3] > 1 ? "s" : ""));*/
    return sb.toString();
}
    
}
