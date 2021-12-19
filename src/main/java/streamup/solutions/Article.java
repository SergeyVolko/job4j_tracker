package streamup.solutions;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String str = origin.trim();
        str = str.replaceAll("\\p{Punct}", "");
        String[] origins = str.split("\\s+");
        str = line.trim();
        str = str.replaceAll("\\p{Punct}", "");
        String[] lines = str.split("\\s+");
        Set<String> setOrigin = Arrays.stream(origins).collect(Collectors.toSet());
        Set<String> setLine = Arrays.stream(lines).collect(Collectors.toSet());
        return setOrigin.containsAll(setLine);
    }
}
