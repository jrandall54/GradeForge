package gradeforge;

/**
 * Represents a student enrolled in the system, indentified by a name and ID.
 */
public class Student {
    private String name;
    private String studentId;

    /**
     * Constructs a new Student
     *
     * @param name                      the name of the student
     * @param studentId                 the unique identified for the student
     * @throws IllegalArgumentException if the name or studentId is null or blank
     */
    public Student(String name, String studentId) {
        if (name == null) {
            throw new IllegalArgumentException("Student name cannot be null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        if (studentId == null) {
            throw new IllegalArgumentException("Student id cannot be null");
        }
        if (studentId.isBlank()) {
            throw new IllegalArgumentException("Student id cannot be blank");
        }

        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}
