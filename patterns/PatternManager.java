package patterns;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PatternManager {
    private List<Pattern> patterns;

    public PatternManager(String path) {
        try {
            patterns = Files.lines(Paths.get(path)).map(PatternManager::getPatternFromString).collect(Collectors.toList());
        } catch (Exception ignored) {
        }
    }

    public List<Pattern> getAllPatterns() {
        return patterns;
    }

    private static Pattern getPatternFromString(String str) {
        String[] args = str.replace("\"", "").split(";");
        return new Pattern(Integer.parseInt(args[0]), args[1], args[2]);
    }
}
