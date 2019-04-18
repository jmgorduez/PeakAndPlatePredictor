package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IPeakAndPlateLineSplitter {
    String licensePlateNumber();
    LocalDate date();
    LocalTime time();
}
