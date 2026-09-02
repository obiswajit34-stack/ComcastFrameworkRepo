package genericUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

    // Generate random number
    public int generateRandomNumber() {
        Random r = new Random();
        return r.nextInt();
    }

    // Generate random number with limit
    public int generateRandomNumber(int limit) {
        Random r = new Random();
        return r.nextInt(limit);
    }

    // Generate current date in yyyy-MM-dd format
    public String generateCurrentDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);

        /*
         * Alternative:
         * LocalDate ld = LocalDate.now();
         * return ld.toString();
         */
    }
    public String getRequiredDate(int days) {
        LocalDate date = LocalDate.now().plusDays(days);
        return date.toString();
    }

    // Generate future or past date
    public String generateSpecificDate(String by, int diff) {

        LocalDate ld = LocalDate.now();

        if (by.equalsIgnoreCase("Days") && diff > 0) {
            return ld.plusDays(diff).toString();
        }
        else if (by.equalsIgnoreCase("Days") && diff < 0) {
            return ld.minusDays(Math.abs(diff)).toString();
        }
        else if (by.equalsIgnoreCase("Months") && diff > 0) {
            return ld.plusMonths(diff).toString();
        }
        else if (by.equalsIgnoreCase("Months") && diff < 0) {
            return ld.minusMonths(Math.abs(diff)).toString();
        }
        else if (by.equalsIgnoreCase("Years") && diff > 0) {
            return ld.plusYears(diff).toString();
        }
        else if (by.equalsIgnoreCase("Years") && diff < 0) {
            return ld.minusYears(Math.abs(diff)).toString();
        }
        else {
            return ld.toString();
        }
    }
}