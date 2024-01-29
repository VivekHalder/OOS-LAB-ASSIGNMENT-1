import java.util.Scanner;

class Date {
    private int day;
    private int month;
    private int year;

    // Constructors
    public Date() {
        this(1, 1, 1970);
    }

    public Date(int day) {
        this(day, 1, 1970);
    }

    public Date(int day, int month) {
        this(day, month, 1970);
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getter methods
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Member functions
    public Date getPreviousDay() {
        int previousDay = day - 1;
        int previousMonth = month;
        int previousYear = year;

        if (previousDay < 1) {
            previousMonth--;
            if (previousMonth < 1) {
                previousMonth = 12;
                previousYear--;
            }
            previousDay = daysInMonth(previousMonth, previousYear);
        }

        return new Date(previousDay, previousMonth, previousYear);
    }

    public Date getNextDay() {
        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;

        int daysInCurrentMonth = daysInMonth(month, year);

        if (nextDay > daysInCurrentMonth) {
            nextDay = 1;
            nextMonth++;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }

        return new Date(nextDay, nextMonth, nextYear);
    }

    public void printDay() {
        System.out.println("Date: " + day + "/" + month + "/" + year);
    }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

class DateDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a date object using various constructors
        Date defaultDate = new Date();
        Date dayMonthDate = new Date(15, 7);
        Date yearDate = new Date(10, 5, 2022);
        Date userDate;

        // Accept user input for a custom date
        System.out.println("Enter a custom date:");
        System.out.print("Day: ");
        int customDay = scanner.nextInt();
        System.out.print("Month: ");
        int customMonth = scanner.nextInt();
        System.out.print("Year: ");
        int customYear = scanner.nextInt();
        userDate = new Date(customDay, customMonth, customYear);

        // Print the next and previous day for each date
        printNextAndPreviousDay("Default Date", defaultDate);
        printNextAndPreviousDay("Day-Month Date", dayMonthDate);
        printNextAndPreviousDay("Year Date", yearDate);
        printNextAndPreviousDay("User Date", userDate);

        scanner.close();
    }

    private static void printNextAndPreviousDay(String label, Date date) {
        System.out.println("\n" + label + ":");
        date.printDay();

        // Print the next day
        Date nextDay = date.getNextDay();
        System.out.print("Next Day: ");
        nextDay.printDay();

        // Print the previous day
        Date previousDay = date.getPreviousDay();
        System.out.print("Previous Day: ");
        previousDay.printDay();
    }
}
