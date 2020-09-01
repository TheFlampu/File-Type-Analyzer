package algorithms;

import patterns.Pattern;

import java.util.concurrent.Callable;

public interface AlgorithmInterface extends Callable<Result> {
    boolean containsPattern(Pattern pattern);
}
