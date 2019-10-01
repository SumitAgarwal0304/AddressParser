package com.parsingaddress.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * FOr comman utility methods
 */
public class CommonUtils {

    /**
     * This method will check if the given string contains any of the given strings below
     * @param givenString
     * @return
     */
    public static boolean containsGivenTypeOfString(String givenString) {
        ArrayList<String> numberString = new ArrayList<>(Arrays.asList("No.", "No", "Number", "Number.","no."));
        return numberString.contains(givenString);
    }
}
