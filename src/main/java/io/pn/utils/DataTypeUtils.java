package io.pn.utils;

public class DataTypeUtils {
    public static String extractType(String data) {
        if(validInteger(data)) {
            return "Integer";
        }else if(validDouble(data)) {
            return "Double";
        }else if(validBoolean(data)) {
            return "Boolean";
        }else {
            return "String";
        }
    }

    private static boolean validBoolean(String data) {
        return data.equalsIgnoreCase("false") || data.equalsIgnoreCase("true");
    }

    private static boolean validDouble(String data) {
        try {
            Double.parseDouble(data);
            return true;
        }catch(NumberFormatException ex) {
            return false;
        }
    }

    private static boolean validInteger(String data) {
        try {
            Integer.parseInt(data);
            return true;
        }catch(NumberFormatException ex) {
            return false;
        }
    }
}
