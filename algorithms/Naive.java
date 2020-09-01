package algorithms;

import patterns.Pattern;
import patterns.PatternManager;

import java.io.File;

public class Naive extends AbstractAlgorithm {

    public Naive(File file, PatternManager patternManager) {
        super(file, patternManager);
    }

    @Override
    public boolean containsPattern(Pattern pattern) {
        for (int i = 0; i < getTextFromFile().length() - pattern.getPattern().length() + 1; i++) {
            boolean patternIsFound = true;

            for (int j = 0; j < pattern.getPattern().length(); j++) {
                if (getTextFromFile().charAt(i + j) != pattern.getPattern().charAt(j)) {
                    patternIsFound = false;
                    break;
                }
            }

            if (patternIsFound) {
                return true;
            }
        }

        return false;
    }
}
