package com.parsingaddress.util;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonUtils {
    public static boolean containsGivenTypeOfString(String givenString) {
        ArrayList<String> numberString = new ArrayList<String>(Arrays.asList("No.", "No", "Number", "Number.","no."));
        return numberString.contains(givenString);
    }
}
