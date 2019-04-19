package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IPeakAndPlateLineSplitter {
    String licensePlateNumber();
    LocalDate date();
    LocalTime time();
}
