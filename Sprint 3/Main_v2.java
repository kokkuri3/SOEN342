import java.util.*;

/* 
 * Darren Vafi  40246358
 * Sarah Amri   40210908
 * 
 * Main.java will be used to implement operations iteratively 
 * depending on the process. In this file, an Instructor class is made
 * temporarily in order to implement ProcessOfferings class and its methods.
 * There is no object instantiation of the Instructor class in this file, just the implementation.
 * 
 * 2024/11/01 added ProcessBookings class for Use Case 2, capacity/availability changes to Offering object instantiations 
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

}

// For Use Case 2 - Process Bookings
class Client {
    private String name;
    private String phoneNumber;
    private String email;
    private int age;

    public Client(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // method to check if the client is under 18
    public boolean isUnderage() {
        return age < 18;
    }

}

// =======================================================
// * SOEN 342 - Use Case 1 - Process Offerings 10/17/2024
class Offering {
    private String lessonType;
    // Sprint 3: changed mode to 'capacity' to represent the number of people that
    // can be in a group. Created int availability to represent the number of spots
    // private String mode; // group or private
    private int capacity;
    private int availability;
    private String location;
    private String instructorName;
    private boolean available;
    private Date startTime;
    private Date endTime;

    public Offering(String lessonType, int capacity, String location, Date startTime, Date endTime) {
        this.lessonType = lessonType;
        // this.mode = mode;
        this.capacity = capacity;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        // If offerings are initially available
        this.available = true;
    }

    public int getCapacity() {
        return capacity;
    }

    // get availability, tied to capacity
    public int getAvailability() {
        return availability;
    }

    // a solo lesson will have a capacity of 1, and a group lesson can hold up to
    // 100 people for example
    public boolean isGroupLesson() {
        return capacity > 1;
    }

    public String getLessonType() {
        return lessonType;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable(Offering offering) {

        if (offering.getAvailability() < offering.getCapacity()) {
            System.out.println(
                    "Offering is available: Spots left is " + (offering.getCapacity() - offering.getAvailability()));
            return true;
        } else {
            System.out.println("Offering is not available.");
            return false;
        }
    }

    // increment and decrement availability based on an offering being booked or

    public void incrementAvailability(Offering offering) {
        offering.availability++;
    }

    // unbooked
    public void decrementAvailability(Offering offering) {
        offering.availability--;
    }

    public void assignInstructor(String instructorName) {
        this.instructorName = instructorName;
        this.available = true; // Available for clients to book once an instructor is assigned
    }

    public void bookOffering() {
        this.available = false; // Mark offering as unavailable after booking
    }

    public String getDetails() {
        return location + ": " + startTime + " - " + endTime + " (" + capacity + ") Instructor: " + instructorName
                + " Available: " + available;
    }

}

// Lesson class - Instructor will be assigned a Lesson, then only then will
// an offerging be created
class Lesson {
    private String lessonType;
    private String mode;
    private String location;
    private Date startTime;
    private Date endTime;

    public Lesson(String lessonType, String mode, String location, Date startTime, Date endTime) {
        this.lessonType = lessonType;
        this.mode = mode;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getLessonType() {
        return lessonType;
    }

    public String getMode() {
        return mode;
    }

    public String getLocation() {
        return location;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
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

    public void addOffering(List<Offering> offerings, String lessonType, int capacity, String location, Date startTime,
            Date endTime) {
        Offering newOffering = new Offering(lessonType, capacity, location, startTime, endTime);
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

    // public void updateOffering(List<Offering> offerings, String
    // lessonType, String location, Date startTime, Date endTime)

    public void updateOffering(List<Offering> offerings, int capacity, String lessonType, String location,
            Date startTime,
            Date endTime) {
        for (Offering offering : offerings) {
            if (offering.getLessonType().equals(lessonType) && offering.getLocation().equals(location)) {
                offering.bookOffering();
                offering = new Offering(lessonType, capacity, location, startTime, endTime);
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
    public void addOffering(String lessonType, int capacity, String location, Date startTime, Date endTime) {
        // Offering newOffering = new Offering(lessonType, mode, location, startTime,
        // endTime);
        Offering newOffering = new Offering(lessonType, capacity, location, startTime, endTime);
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
            if (offering.isAvailable(offering) && offering.getDetails().contains(lessonType)
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
            if (offering.isAvailable(offering)) {
                System.out.println(offering.getDetails());
            }
        }
    }

    // Method to book an offering
    public void bookOffering(String lessonType, String location, Date startTime) {
        for (Offering offering : offerings) {
            if (offering.getDetails().contains(lessonType) && offering.getDetails().contains(location)
                    && offering.isAvailable(offering)) {
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
                    && !offering.isAvailable(offering)) {
                offering.bookOffering();
                System.out.println("Booking successfully cancelled.");
                return;
            }
        }
        System.out.println("No booking found to cancel.");
    }
}
// End of Process Offerings
// =======================================================

// SOEN 342 - Use Case 2 - Process Bookings 11/1/2024
// =======================================================
class ProcessBookings {
    private List<Offering> offerings;

    // Constructor, takes in a list of offerings
    public ProcessBookings(List<Offering> offerings) {
        this.offerings = offerings;
    }

    // Register a new client (with optional guardian if under 18)
    // example, if the client is under 18, a guardian is required, so we'd call this
    // method
    public Client registerClient(int age, String name, String phoneNumber, String email) {
        // guardian must be 18+
        if (age < 18) {
            System.out.println("Guardian required for client under 18.");
            return null;
        }
        Client newClient = new Client(name, phoneNumber, email);
        newClient.setAge(age);
        return newClient;

    }

    // Method to book an offering
    public void bookOffering(String lessonType, String location, Date startTime) {
        for (Offering offering : offerings) {
            if (offering.getDetails().contains(lessonType) && offering.getDetails().contains(location)
                    && offering.isAvailable(offering)) {
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
                    && !offering.isAvailable(offering)) {
                offering.bookOffering();
                System.out.println("Booking successfully cancelled.");
                return;
            }
        }
        System.out.println("No booking found to cancel.");
    }
}
// End of Process Bookings
// =======================================================