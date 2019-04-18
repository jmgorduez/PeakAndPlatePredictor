package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateLineSplitter;
import ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.BLANK_SPACE_STRING;

public class PeakAndPlateLineSplitter implements IPeakAndPlateLineSplitter {

    private String licensePlateNumber;

    public PeakAndPlateLineSplitter(String line){
        Queue<String> lineElements = new ArrayDeque<>(Arrays.asList(line.split(BLANK_SPACE_STRING)));
        licensePlateNumber = lineElements.poll();
    }

    @Override
    public String licensePlateNumber() {
        return licensePlateNumber;
    }

    @Override
    public LocalDate date() {
        return null;
    }

    @Override
    public LocalTime time() {
        return null;
    }
}
