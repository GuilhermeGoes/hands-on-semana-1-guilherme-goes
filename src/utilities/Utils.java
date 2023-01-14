package utilities;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Logger;

public final class Utils {

    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public static Integer validIntegerValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            LOGGER.severe(String.format("Valor não corresponde com o tipo => %s", value));
        }

        return 0;
    }

    public static Double validDoubleValue(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            LOGGER.severe(String.format("Valor não corresponde com o tipo => %s", value));
        }

        return 0.0;
    }

    public static Double monetaryConvert(String value) {
        Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();

        try {
            NumberFormat format = NumberFormat.getNumberInstance(locale);
            return format.parse(value).doubleValue();

        } catch (ParseException e) {

        }

        return 0.0;
    }
}
