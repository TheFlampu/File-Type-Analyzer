package analyzer;

import algorithms.Result;
import factory.AlgorithmFactory;
import patterns.PatternManager;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PatternManager patternManager = new PatternManager(args[1]);
        AlgorithmFactory algorithmFactory = new AlgorithmFactory(patternManager);

        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        assert files != null;
        List<Callable<Result>> callable = Arrays.stream(files)
                .map(el -> algorithmFactory.newInstance("RK", el))
                .collect(Collectors.toList());
        ExecutorService executorService = Executors.newFixedThreadPool(files.length);

        try {
            List<Future<Result>> results = executorService.invokeAll(callable);
            for (Future<Result> result : results) {
                Result res = result.get();
                System.out.println(res.getFileName() + ": " + (res.getPattern() != null ? res.getPattern().getName() : "Unknown file type"));
            }
            executorService.shutdown();
        } catch (Exception ignored) {
        }
    }
}
