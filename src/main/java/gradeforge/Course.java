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

    /** Converts the letter grade of this course into numeric grade points
     *
     * @return the numeric grade points (A = 4.0, B = 3.0, C = 2.0, D = 1.0, F = 0.0)
     */
    public double getGradePoints() {
        if (letterGrade == null) {
            return 0.0;
        }

        switch (letterGrade.toUpperCase()) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%d credits) - Grade: %s", name, creditHours, letterGrade);
    }

}
