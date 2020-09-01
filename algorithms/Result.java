package algorithms;

import patterns.Pattern;

public class Result {
    final String fileName;
    final Pattern pattern;

    public Result(String fileName, Pattern pattern) {
        this.fileName = fileName;
        this.pattern = pattern;
    }

    public String getFileName() {
        return fileName;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
