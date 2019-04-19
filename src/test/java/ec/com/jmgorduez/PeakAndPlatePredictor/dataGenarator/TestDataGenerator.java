package ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.utils.NonWorkingDateCheckerUIO;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.PeakAndPlateRuleUIO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.enums.TypePeakAndPlateRuleUIO.*;

public class TestDataGenerator {

    public static final String EMPTY_STRING = "";

    public static final PeakAndPlateRuleUIO MONDAYS_NOT_ON_THE_ROAD
            = new PeakAndPlateRuleUIO(MONDAYS_NOT_ON_ROAD, new NonWorkingDateCheckerUIO());
    public static final PeakAndPlateRuleUIO WEDNESDAYS_NOT_ON_THE_ROAD
            = new PeakAndPlateRuleUIO(WEDNESDAYS_NOT_ON_ROAD, new NonWorkingDateCheckerUIO());
    public static final PeakAndPlateRuleUIO FRIDAYS_NOT_ON_THE_ROAD
            = new PeakAndPlateRuleUIO(FRIDAYS_NOT_ON_ROAD, new NonWorkingDateCheckerUIO());

    public static final String PCI_8580 = "PCI8580";
    public static final String PCI_8581 = "PCI8581";
    public static final String PCI_8584 = "PCI8584";
    public static final String PCI_8585 = "PCI8585";

    public static final LocalDate JAN_01_2019 = LocalDate.parse("2019-01-01");
    public static final LocalDate APR_15_2019 = LocalDate.parse("2019-04-15");
    public static final LocalDate APR_16_2019 = LocalDate.parse("2019-04-16");
    public static final LocalDate APR_19_2019 = LocalDate.parse("2019-04-19");
    public static final LocalDate APR_20_2019 = LocalDate.parse("2019-04-20");
    public static final LocalDate APR_21_2019 = LocalDate.parse("2019-04-21");
    public static final LocalDate MAY_01_2019 = LocalDate.parse("2019-05-01");
    public static final LocalDate MAY_24_2019 = LocalDate.parse("2019-05-24");
    public static final LocalDate NOV_03_2019 = LocalDate.parse("2019-11-03");
    public static final LocalDate NOV_04_2019 = LocalDate.parse("2019-11-04");

    public static final Year _2019 = Year.parse("2019");

    public static final LocalTime _07_00 = LocalTime.parse("07:00");
    public static final LocalTime _08_00 = LocalTime.parse("08:00");
    public static final LocalTime _09_30 = LocalTime.parse("09:30");
    public static final LocalTime _09_31 = LocalTime.parse("09:31");
    public static final LocalTime _16_00 = LocalTime.parse("16:00");
    public static final LocalTime _19_30 = LocalTime.parse("19:30");
    public static final LocalTime _19_31 = LocalTime.parse("19:31");

    public static final String PCI_8580_2019_04_15_07_00 = "PCI8580 2019-04-15 07:00";
    public static final String PCI_8580_2019_04_15_10_00 = "PCI8580 2019-04-15 10:00";
    public static final String PCI_8581_2019_04_16_07_00 = "PCI8581 2019-04-16 07:00";

    public static final String END_OF_LINE = "\n";
}
