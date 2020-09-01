package patterns;

public class Pattern {
    private final int priority;
    private final String pattern;
    private final String Name;

    public Pattern(int priority, String pattern, String name) {
        this.priority = priority;
        this.pattern = pattern;
        Name = name;
    }

    public int getPriority() {
        return priority;
    }

    public String getPattern() {
        return pattern;
    }

    public String getName() {
        return Name;
    }
}
