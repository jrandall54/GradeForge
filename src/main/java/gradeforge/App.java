package gradeforge;

import java.util.Scanner;
import java.util.InputMismatchException;

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

        double totalQualityPoints = 0.0;
        int totalCredits = 0;

        System.out.print("Enter your name: ");
        String studentName = sc.nextLine();

        while (true) {
            System.out.print("Enter course name (or type 'exit' to calculate GPA): ");
            String courseName = sc.nextLine();

            if (courseName.equalsIgnoreCase("exit")) {
                break;
            }

            int credits = 0;
            boolean isValid = false;

            while (!isValid) {
                System.out.print("Enter credit hours: ");
                try {
                    credits = sc.nextInt();
                    sc.nextLine();

                    if (credits > 0) {
                        isValid = true;
                    } else {
                        System.out.println("Credit hours must be a positive integer.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for credit hours");
                    sc.nextLine();
                }
            }

            String letterGrade = "";
            while (true) {
                System.out.print("Enter letter grade (A, B, C, D, F): ");
                letterGrade = sc.nextLine();

                String upperGrade = letterGrade.toUpperCase();
                if (upperGrade.equals("A") || upperGrade.equals("B") ||
                    upperGrade.equals("C") || upperGrade.equals("D") ||
                    upperGrade.equals("F")) {
                        break;
                    }
                System.out.println("Invalid grade entered. Please enter A, B, C, D, or F.");
            }

            Course c = new Course(courseName, credits, letterGrade);

            totalQualityPoints += c.getGradePoints() * c.getCreditHours();
            totalCredits += c.getCreditHours();

        }

        double cumulativeGpa = totalCredits > 0 ? totalQualityPoints / totalCredits : 0.0;

        System.out.println();
        System.out.printf("Hello, %s!%n", studentName);
        System.out.printf("Total Credits: %d | Cumulative GPA: %.2f%n", totalCredits, cumulativeGpa);

        sc.close();
    }
}
