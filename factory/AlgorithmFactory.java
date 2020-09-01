package factory;

import algorithms.AlgorithmInterface;
import algorithms.KMP;
import algorithms.Naive;
import algorithms.RK;
import patterns.PatternManager;

import java.io.File;

public class AlgorithmFactory {
    private final PatternManager patternManager;

    public AlgorithmFactory(PatternManager patternManager) {
        this.patternManager = patternManager;
    }

    public AlgorithmInterface newInstance(String type, File file) {
        switch (type) {
            case "RK": return new RK(file, patternManager);
            case "KMP": return new KMP(file, patternManager);
            default: return new Naive(file, patternManager);
        }
    }
}
