package enumproject;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;


enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

// Enum for Activities
enum Activity {
    HIKING, SWIMMING, SKIING, PUMPKIN_CARVING
}

// Class to organize seasonal activities
class SeasonalActivityOrganizer {
    private EnumMap<Season, EnumSet<Activity>> seasonalActivities;

    // Constructor initializes the EnumMap with EnumSets
    public SeasonalActivityOrganizer() {
        seasonalActivities = new EnumMap<>(Season.class);
        for (Season season : Season.values()) {
            seasonalActivities.put(season, EnumSet.noneOf(Activity.class));
        }
    }

    // Get activities for a specific season
    public Set<Activity> getActivitiesForSeason(Season season) {
        return seasonalActivities.getOrDefault(season, EnumSet.noneOf(Activity.class));
    }

    // Add activity for a specific season
    public Set<Activity> addActivityForSeason(Activity activity, Season season) {
        EnumSet<Activity> activities = seasonalActivities.get(season);
        if (activities != null) {
            activities.add(activity);
        } else {
            throw new IllegalArgumentException("Unknown season: " + season);
        }
        return activities;
    }

    // Remove activity from all seasons
    public Set<Activity> removeActivityFromAllSeasons(Activity activity) {
        for (EnumSet<Activity> activities : seasonalActivities.values()) {
            activities.remove(activity);
        }
        return getAllActivities();
    }

    // Get all activities from all seasons
    public Set<Activity> getAllActivities() {
        EnumSet<Activity> allActivities = EnumSet.noneOf(Activity.class);
        for (EnumSet<Activity> activities : seasonalActivities.values()) {
            allActivities.addAll(activities);
        }
        return allActivities;
    }
}

// Main class to demonstrate functionality
public class SeasonApp {
    public static void main(String[] args) {
        // Create an instance of the organizer
        SeasonalActivityOrganizer organizer = new SeasonalActivityOrganizer();

        // Add activities for each season
        organizer.addActivityForSeason(Activity.HIKING, Season.SPRING);
        organizer.addActivityForSeason(Activity.SWIMMING, Season.SUMMER);
        organizer.addActivityForSeason(Activity.SKIING, Season.WINTER);

        // Print all activities
        System.out.println(organizer.getAllActivities());  // [HIKING, SWIMMING, SKIING]

        // Print activities for each season
        System.out.println(organizer.getActivitiesForSeason(Season.SPRING));  // [HIKING]
        System.out.println(organizer.getActivitiesForSeason(Season.SUMMER));  // [SWIMMING]
        System.out.println(organizer.getActivitiesForSeason(Season.WINTER));  // [SKIING]

        // Remove hiking from all seasons
        organizer.removeActivityFromAllSeasons(Activity.HIKING);

        // Print activities for each season after removal
        System.out.println(organizer.getActivitiesForSeason(Season.SPRING));  // []
    }
}

