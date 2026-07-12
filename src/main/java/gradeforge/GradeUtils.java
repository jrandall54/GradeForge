package gradeforge;

/**
 * Utility class containing static methods for grade validation and conversion.
 */
public final class GradeUtils {

    // Private constructor to prevent instantiation
    private GradeUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Checks if given letter grade is valid (A, B, C, D or F, case-insenstive).
     *
     * @param     grade the letter grade to validate
     * @return    true if the grade is valid; false otherwise
     */
    public static boolean isValidGrade(String grade) {
        if (grade == null) {
            return false;
        }

        String upperGrade = grade.trim().toUpperCase();
        return upperGrade.equals("A") || upperGrade.equals("B") ||
               upperGrade.equals("C") || upperGrade.equals("D") ||
               upperGrade.equals("F");
    }

    /**
     * Coverts a letter grade into numeric grade points.
     *
     * @param grade    the letter grade (A, B, C, D, F)
     * @return         the numberic grade points (A= 4.0, B = 3.0, C = 2.0, D = 1.0, F = 0.0)
     * @throws         IllegalArgumentException if the grade is invalid
     */
    public static double toGradePoints(String grade) {
        if (!isValidGrade(grade)) {
            throw new IllegalArgumentException("Invalid grade: " + grade);
        }

        switch (grade= grade.trim().toUpperCase()) {
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

}
