package algorithms;

import patterns.Pattern;
import patterns.PatternManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public abstract class AbstractAlgorithm implements AlgorithmInterface {
    private final File file;
    private final PatternManager patternManager;

    protected AbstractAlgorithm(File file, PatternManager patternManager) {
        this.file = file;
        this.patternManager = patternManager;
    }

    public String getFileName() {
        return file.getName();
    }

    public PatternManager getPatternManager() {
        return patternManager;
    }

    public String getTextFromFile() {
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            return new String(inputStream.readAllBytes());
        } catch (Exception ignored) {
        }
        return null;
    }

    protected Pattern check() {
        List<Pattern> patterns = getPatternManager().getAllPatterns();
        Pattern result = null;
        int priority = 0;
        for (Pattern pattern : patterns) {
            if (containsPattern(pattern) && pattern.getPriority() > priority) {
                result = pattern;
                priority = pattern.getPriority();
            }
        }
        return result;
    }

    @Override
    public Result call() {
        return new Result(getFileName(), check());
    }
}
