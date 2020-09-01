package algorithms;

import patterns.Pattern;
import patterns.PatternManager;

import java.io.File;

public class KMP extends AbstractAlgorithm {

    public KMP(File file, PatternManager patternManager) {
        super(file, patternManager);
    }

    @Override
    public boolean containsPattern(Pattern pattern) {
        int[] prefixFunc = prefixFunction(pattern.getPattern());
        int j = 0;

        for (int i = 0; i < getTextFromFile().length(); i++) {
            while (j > 0 && getTextFromFile().charAt(i) != pattern.getPattern().charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (getTextFromFile().charAt(i) == pattern.getPattern().charAt(j)) {
                j += 1;
            }

            if (j == pattern.getPattern().length()) {
                return true;
            }
        }
        return false;
    }

    private static int[] prefixFunction(String str) {
        int[] prefixFunc = new int[str.length()];

        for (int i = 1; i < str.length(); i++) {
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            prefixFunc[i] = j;
        }

        return prefixFunc;
    }
}
