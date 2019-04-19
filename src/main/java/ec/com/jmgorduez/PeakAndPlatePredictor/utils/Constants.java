package ec.com.jmgorduez.PeakAndPlatePredictor.utils;

import java.time.LocalTime;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String NULL_STRING = null;

    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FOUR = 4;
    public static final Integer FIVE = 5;
    public static final Integer SIX = 6;
    public static final Integer SEVEN = 7;
    public static final Integer EIGHT = 8;
    public static final Integer NINE = 9;
    public static final Integer ZERO = 0;

    public static final LocalTime _06_59 = LocalTime.parse("06:59");
    public static final LocalTime _09_31 = LocalTime.parse("09:31");
    public static final LocalTime _15_59 = LocalTime.parse("15:59");
    public static final LocalTime _19_31 = LocalTime.parse("19:31");

    public static final MonthDay JANUARY_01 = MonthDay.parse("--01-01");
    public static final MonthDay MAY_01 = MonthDay.parse("--05-01");
    public static final MonthDay MAY_24 = MonthDay.parse("--05-24");
    public static final MonthDay AUGUST_10 = MonthDay.parse("--09-10");
    public static final MonthDay OCTOBER_09 = MonthDay.parse("--10-09");
    public static final MonthDay NOVEMBER_02 = MonthDay.parse("--11-02");
    public static final MonthDay NOVEMBER_03 = MonthDay.parse("--11-03");
    public static final MonthDay DECEMBER_06 = MonthDay.parse("--12-06");
    public static final MonthDay DECEMBER_25 = MonthDay.parse("--12-25");

    public static final List<MonthDay> HOLIDAYS_UIO = Arrays.asList(JANUARY_01,
            MAY_01, MAY_24, AUGUST_10, OCTOBER_09, NOVEMBER_02, NOVEMBER_03, DECEMBER_06, DECEMBER_25);

    public static final String BLANK_SPACE_STRING = " ";
    public final static String INFORMATION_MESSAGE
            = "Please, enter Lisence plate number date and time following this format XXX0000 YYYY-MM-DD HH:MM or ENTER to exit.";
}
