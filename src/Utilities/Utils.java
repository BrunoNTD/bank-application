package Utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formatedValue = new DecimalFormat("R$ #,##0.00");
    public static String doubleToString (Double value) {
        return formatedValue.format(value);
    }
}
