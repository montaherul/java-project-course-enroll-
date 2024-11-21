import java.util.ArrayList;
import java.util.Scanner;

public class OnlineCourseSystem {
    // Store course details
    static ArrayList<String> courseNames = new ArrayList<>();
    static ArrayList<String> teacherNames = new ArrayList<>();
    static ArrayList<String> trainingHistories = new ArrayList<>();
    static ArrayList<Integer> enrollments = new ArrayList<>();

    // Scanner for user input
    static Scanner scanner = new Scanner(System.in);

    // Add a course
    static void addCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        courseNames.add(courseName);

        System.out.print("Enter teacher name: ");
        String teacherName = scanner.nextLine();
        teacherNames.add(teacherName);

        System.out.print("Enter training history (optional): ");
        String trainingHistory = scanner.nextLine();
        trainingHistories.add(trainingHistory.isEmpty() ? "Not provided" : trainingHistory);

        enrollments.add(0); // Initialize enrollments to 0
        System.out.println("Course added successfully!");
    }

    // Display courses
    static void displayCourses() {
        if (courseNames.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < courseNames.size(); i++) {
            System.out.println((i + 1) + ". " + courseNames.get(i));
            System.out.println("   Teacher: " + teacherNames.get(i));
            System.out.println("   Training History: " + trainingHistories.get(i));
            System.out.println("   Enrollments: " + enrollments.get(i));
        }
    }

    // Enroll in a course
    static void enrollInCourse() {
        displayCourses();
        if (courseNames.isEmpty()) return;

        System.out.print("\nEnter the course number to enroll: ");
        int courseNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (courseNumber > 0 && courseNumber <= courseNames.size()) {
            enrollments.set(courseNumber - 1, enrollments.get(courseNumber - 1) + 1);
            System.out.println("Enrollment successful in course: " + courseNames.get(courseNumber - 1));
        } else {
            System.out.println("Invalid course number.");
        }
    }

    // Remove a course
    static void removeCourse() {
        displayCourses();
        if (courseNames.isEmpty()) return;

        System.out.print("\nEnter the course number to remove: ");
        int courseNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (courseNumber > 0 && courseNumber <= courseNames.size()) {
            courseNames.remove(courseNumber - 1);
            teacherNames.remove(courseNumber - 1);
            trainingHistories.remove(courseNumber - 1);
            enrollments.remove(courseNumber - 1);
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Invalid course number.");
        }
    }

    // Main menu
    static void showMenu() {
        System.out.println("\n--- Online Course Enrollment System ---");
        System.out.println("1. Add Course");
        System.out.println("2. Display Courses");
        System.out.println("3. Enroll in a Course");
        System.out.println("4. Remove Course");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    displayCourses();
                    break;
                case 3:
                    enrollInCourse();
                    break;
                case 4:
                    removeCourse();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
