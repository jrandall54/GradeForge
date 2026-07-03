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

        System.out.print("Enter letter grade (A, B, C, D, F): ");
        String letterGrade = sc.nextLine();

        double gradePoints;
        switch (letterGrade.toUpperCase()) {
            case "A":
                gradePoints = 4.0;
                break;
            case "B":
                gradePoints = 3.0;
                break;
            case "C":
                gradePoints = 2.0;
                break;
            case "D":
                gradePoints = 1.0;
                break;
            case "F":
                gradePoints = 0.0;
                break;
            default:
                System.out.println("Invalid grade entered. Defaulting to 0.0 points.");
                gradePoints = 0.0;
                break;
        }

        System.out.println();
        System.out.printf("Hello, %s!%n", studentName);
        System.out.printf("Course: %s | Grade: %s | Grade Points: %.1f%n", courseName, letterGrade.toUpperCase(), gradePoints);

        sc.close();
    }
}
