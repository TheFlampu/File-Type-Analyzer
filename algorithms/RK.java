package algorithms;

import patterns.Pattern;
import patterns.PatternManager;

import java.io.File;

public class RK extends AbstractAlgorithm {
    public RK(File file, PatternManager patternManager) {
        super(file, patternManager);
    }

    @Override
    public boolean containsPattern(Pattern pt) {
        String text = getTextFromFile();
        String pattern = pt.getPattern();

        if (pattern.length() > text.length()) {
            return false;
        }

        int a = 53;
        long m = 1_000_000_000 + 9;

        long patternHash = 0;
        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += (int) (pattern.charAt(i)) * pow;
            patternHash %= m;

            currSubstrHash += (int) (text.charAt(text.length() - pattern.length() + i)) * pow;
            currSubstrHash %= m;

            if (i != pattern.length() - 1) {
                pow = pow * a % m;
            }
        }

        for (int i = text.length(); i >= pattern.length(); i--) {
            if (patternHash == currSubstrHash) {
                boolean patternIsFound = true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i - pattern.length() + j) != pattern.charAt(j)) {
                        patternIsFound = false;
                        break;
                    }
                }

                if (patternIsFound) {
                    return true;
                }
            }

            if (i > pattern.length()) {
                currSubstrHash = (currSubstrHash - (int) (text.charAt(i - 1)) * pow % m + m) * a % m;
                currSubstrHash = (currSubstrHash + (int) (text.charAt(i - pattern.length() - 1))) % m;
            }
        }
        return false;
    }
}
