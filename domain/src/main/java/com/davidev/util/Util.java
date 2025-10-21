package com.davidev.util;

import java.util.Locale;

public class Util {
    public static String n(String string){
        return string == null ? null : string.trim().toLowerCase(Locale.ROOT);
    }
}
