package be.ucll.gerecht.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DateConverter {
    public static LocalDate ConvertStringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //convert String to LocalDate
        return LocalDate.parse(dateString, formatter);
    }

    public static String ConvertToLocalDateString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public static int GetWeekNrFromString(String dateString) {
        LocalDate date = ConvertStringToLocalDate(dateString);
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfWeekBasedYear());
    }

}
