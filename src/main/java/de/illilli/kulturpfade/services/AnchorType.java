package de.illilli.kulturpfade.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnchorType {

    /**
     * should cantain string "-u"; example: "b09-t01-u01-0.1"
     * @param input
     * @return
     */
    public static boolean isUnanchored(String input) {
        String regexPattern = ".*-u.*";
        return matchesPattern(input, regexPattern);
    }

    public static boolean isBase(String input) {
        String regexPattern = ".*-s.*";
        return matchesPattern(input, regexPattern);
    }

    public static boolean isAnchor(String input) {
        String regexPattern = ".*-p.*";
        return matchesPattern(input, regexPattern);
    }

    private static boolean matchesPattern(String input, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        return matcher.matches();
    }
}
