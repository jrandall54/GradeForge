package gradeforge;

import java.util.Scanner;

/**
 * GradeForge — A Student Grade & Course Tracker.
 *
 * This is the application entry point. It will evolve from a simple
 * placeholder into a full CLI application and eventually a JavaFX GUI
 * as you progress through the PAW roadmap.
 */
public class App {

    public static void main(String[] args) {
        String appName = "GradeForge";
        double version = 1.0;

        System.out.println("=================================");
        System.out.printf("  Welcome to the %s (v%.1f)%n", appName, version);
        System.out.println("=================================");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter course name: ");
        String courseName = sc.nextLine();

        System.out.println();
        System.out.printf("Hello, %s! Welcome to your grade tracker for %s.%n", studentName, courseName);

        sc.close();
    }
}
