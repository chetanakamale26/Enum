package enumproject;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    // Method to return the type of day (Weekday or Weekend)
    public String getDayType() {
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                return "Weekend";
            default:
                return "Weekday";
        }
    }

    // Method to check if the day is a Weekend (Saturday or Sunday)
    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }

    // Overridden toString method to return the full name of the day
    @Override
    public String toString() {
        return this.name();
    }

    // Method to compare the order of days in a week
    public int compareDays(Day day) {
        if (this.ordinal() < day.ordinal()) {
            return -1; // Current day is earlier in the week
        } else if (this.ordinal() > day.ordinal()) {
            return 1;  // Current day is later in the week
        } else {
            return 0;  // Both days are the same
        }
    }
}
public class DayApp {
    public static void main(String[] args) {
        // Print each day and its type (Weekday or Weekend)
        for (Day day : Day.values()) {
            System.out.println(day + " is a " + day.getDayType());
        }

        // Check if a specific day is a weekend
        Day day1 = Day.MONDAY;
        Day day2 = Day.SATURDAY;
        System.out.println(day1 + " is weekend: " + day1.isWeekend());
        System.out.println(day2 + " is weekend: " + day2.isWeekend());

        // Compare two days to check which one is earlier or later in the week
        Day dayA = Day.WEDNESDAY;
        Day dayB = Day.FRIDAY;
        
        int comparisonResult = dayA.compareDays(dayB);
        if (comparisonResult == -1) {
            System.out.println(dayA + " is earlier than " + dayB);
        } else if (comparisonResult == 1) {
            System.out.println(dayA + " is later than " + dayB);
        } else {
            System.out.println(dayA + " is the same as " + dayB);
        }
    }
}
