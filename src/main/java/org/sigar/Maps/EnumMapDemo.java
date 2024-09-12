package org.sigar.Maps;

import java.util.EnumMap;
import java.util.Map;

    // Define an enum representing days of the week
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
// ***Enums can have an infinite number of constructors, but only one will be public and accessible outside the enum class.
    public class EnumMapDemo {
        public static void main(String[] args) {
            // Create an EnumMap with Day as the key type
            EnumMap<Day, String> activityMap = new EnumMap<>(Day.class);
            activityMap.put(Day.WEDNESDAY, "Work on the project");
            activityMap.put(Day.THURSDAY, "Team building activity");
            activityMap.put(Day.FRIDAY, "Client calls");
            activityMap.put(Day.SATURDAY, "Family time");
            // Populate the EnumMap with key-value pairs
            activityMap.put(Day.MONDAY, "Go to the gym");
            activityMap.put(Day.TUESDAY, "Attend meetings");

            activityMap.put(Day.SUNDAY, "Rest day");

            // Iterate over the EnumMap and print the keys and values
            for (Map.Entry<Day, String> entry : activityMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }


            // Access specific values
            String activity = activityMap.get(Day.MONDAY);
            System.out.println("Monday's activity: " + activity);

            // Check if a key exists
            boolean hasSunday = activityMap.containsKey(Day.SUNDAY);
            System.out.println("Contains Sunday: " + hasSunday);

            // Removing an entry
            activityMap.remove(Day.SATURDAY);
            System.out.println("After removing Saturday: " + activityMap);
        }
    }


