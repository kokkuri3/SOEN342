import java.util.*;

/* 
 * Darren Vafi  40246358
 * Sarah Amri   40210908
 * 
 * Main.java will be used to implement operations iteratively 
 * depending on the process. In this file, an Instructor class is made
 * temporarily in order to implement ProcessOfferings class and its methods.
 * There is no object instantiation of the Instructor class in this file, just the implementation.
 */

class Instructor {
    private String name;
    private String phoneNumber;
    private String specialization;
    private List<String> availableCities;

    public Instructor(String name, String phoneNumber, String specialization, List<String> availableCities) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.availableCities = availableCities;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public boolean isAvailableInCity(String city) {
        return availableCities.contains(city);
    }

    // Other getter methods or logic as needed
}

// =======================================================
// * SOEN 342 - Use Case 1 - Process Offerings 10/17/2024
class Offering {
    private String lessonType;
    private String mode; // group or private
    private String location;
    private String instructorName;
    private boolean available;
    private Date startTime;
    private Date endTime;

    public Offering(String lessonType, String mode, String location, Date startTime, Date endTime) {
        this.lessonType = lessonType;
        this.mode = mode;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        // If offerings are initially available
        this.available = true;
    }

    public String getLessonType() {
        return lessonType;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignInstructor(String instructorName) {
        this.instructorName = instructorName;
        this.available = true; // Available for clients to book once an instructor is assigned
    }

    public void bookOffering() {
        this.available = false; // Mark offering as unavailable after booking
    }

    public String getDetails() {
        return location + ": " + startTime + " - " + endTime + " (" + mode + ") Instructor: " + instructorName
                + " Available: " + available;
    }

}

// Administrator class implementation
class Administrator {
    private String name;

    public String getName() {
        return name;
    }

    public Administrator(String name) {
        this.name = name;
    }

    public void addOffering(List<Offering> offerings, String lessonType, String mode, String location, Date startTime,
            Date endTime) {
        Offering newOffering = new Offering(lessonType, mode, location, startTime, endTime);
        offerings.add(newOffering);
        System.out.println("Offering added by Administrator: " + lessonType + " at " + location);
    }

    public void deleteOffering(List<Offering> offerings, String lessonType, String location) {
        for (Offering offering : offerings) {
            if (offering.getLessonType().equals(lessonType) && offering.getLocation().equals(location)) {
                offerings.remove(offering);
                System.out.println("Offering deleted by Administrator: " + lessonType + " at " + location);
                return;
            }
        }
        System.out.println("No offering found to delete.");
    }

    public void updateOffering(List<Offering> offerings, String lessonType, String location, Date startTime,
            Date endTime) {
        for (Offering offering : offerings) {
            if (offering.getLessonType().equals(lessonType) && offering.getLocation().equals(location)) {
                offering.bookOffering();
                offering = new Offering(lessonType, offering.getLessonType(), location, startTime, endTime);
                System.out.println("Offering updated by Administrator: " + lessonType + " at " + location);
                return;
            }
        }
        System.out.println("No offering found to update.");
    }

}

class ProcessOfferings {
    private List<Instructor> instructors;
    private List<Offering> offerings;

    public ProcessOfferings() {
        this.instructors = new ArrayList<>();
        this.offerings = new ArrayList<>();
    }

    // Method to add a new offering
    public void addOffering(String lessonType, String mode, String location, Date startTime, Date endTime) {
        Offering newOffering = new Offering(lessonType, mode, location, startTime, endTime);
        offerings.add(newOffering);
    }

    // Method to register a new instructor
    public void registerInstructor(String name, String phoneNumber, String specialization, List<String> cities) {
        Instructor newInstructor = new Instructor(name, phoneNumber, specialization, cities);
        instructors.add(newInstructor);
    }

    // Method to assign an instructor to an offering
    public void assignInstructorToOffering(String lessonType, String mode, String location, Date startTime,
            String instructorName) {
        Offering selectedOffering = null;
        for (Offering offering : offerings) {
            if (offering.isAvailable() && offering.getDetails().contains(lessonType)
                    && offering.getDetails().contains(location)) {
                selectedOffering = offering;
                break;
            }
        }
        // Assign the instructor to the offering, so long as its not null
        if (selectedOffering != null) {
            selectedOffering.assignInstructor(instructorName);
        } else {
            System.out.println("No matching offering available to assign to the instructor.");
        }
    }

    // Method to list all available offerings
    public void listAvailableOfferings() {
        for (Offering offering : offerings) {
            if (offering.isAvailable()) {
                System.out.println(offering.getDetails());
            }
        }
    }

    // Method to book an offering
    public void bookOffering(String lessonType, String location, Date startTime) {
        for (Offering offering : offerings) {
            if (offering.getDetails().contains(lessonType) && offering.getDetails().contains(location)
                    && offering.isAvailable()) {
                offering.bookOffering();
                System.out.println("Offering booked.");
                return;
            }
        }
        System.out.println("No available offering found for booking.");
    }

    // Cancel bookings
    public void cancelBooking(String lessonType, String location, Date startTime) {
        for (Offering offering : offerings) {
            if (offering.getDetails().contains(lessonType) && offering.getDetails().contains(location)
                    && !offering.isAvailable()) {
                offering.bookOffering();
                System.out.println("Booking successfully cancelled.");
                return;
            }
        }
        System.out.println("No booking found to cancel.");
    }
}
// * SOEN 342 - Use Case 1 - Process Offerings 10/17/2024
// =======================================================
