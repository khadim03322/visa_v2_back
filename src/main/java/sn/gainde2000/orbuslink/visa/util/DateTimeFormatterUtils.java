package sn.gainde2000.orbuslink.visa.util;

import java.time.format.DateTimeFormatter;

public class DateTimeFormatterUtils {
    public static DateTimeFormatter get() {
      return   DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
    }
}
