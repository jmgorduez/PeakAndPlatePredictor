package ec.com.jmgorduez.PeakAndPlatePredictor.utils;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils.IPeakAndPlateLineSplitter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.function.Function;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.BLANK_SPACE_STRING;

public class PeakAndPlateLineSplitter implements IPeakAndPlateLineSplitter {

    private String licensePlateNumber;
    private LocalDate date;
    private LocalTime time;

    public PeakAndPlateLineSplitter(String line, Character separatorCharacter,
                                    Function<String, LocalDate> instanceDate,
                                    Function<String, LocalTime> instanceTime){
        Queue<String> lineElements
                = new ArrayDeque<>(Arrays.asList(line.split(String.valueOf(separatorCharacter))));
        licensePlateNumber = lineElements.poll();
        date = instanceDate.apply(lineElements.poll());
        time = instanceTime.apply(lineElements.poll());
    }

    @Override
    public String licensePlateNumber() {
        return licensePlateNumber;
    }

    @Override
    public LocalDate date() {
        return date;
    }

    @Override
    public LocalTime time() {
        return time;
    }
}
