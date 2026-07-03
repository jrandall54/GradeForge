package gradeforge;

/**
 * Represents a course taken by a student including credit hours and final grade.
 */
public class Course {
    private String name;
    private int creditHours;
    private String letterGrade;

    /**
     * Constructs a new Course
     *
     * @param name            the name of the course
     * @param creditHours     the number of credits for course
     * @param letterGrade.    the letter grade earned (A, B, C, D, F)
     */
    public Course(String name, int creditHours, String letterGrade) {
        this.name = name;
        this.creditHours = creditHours;
        this.letterGrade = letterGrade;
    }

    public String getName() {
        return name;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    @Override
    public String toString() {
        return String.format("%s (%d credits) - Grade: %s", name, creditHours, letterGrade);
    }

}
