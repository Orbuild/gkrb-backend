package com.example.gkrb.utils;

import java.util.Arrays;

public class StringUtil {

    public static String ArrayToString(String[] str) {
        return Arrays.toString(str).replace("[", "")
                .replace("]", "")
                .replace(" ", "");
    }

    public static String[] StringToArray(String str) {
        return str.split(",");
    }

}
