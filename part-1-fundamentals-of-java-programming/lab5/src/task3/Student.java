package task3;

public class Student {
    private int studentID;
    private double ratingScore;
    private String firstName;
    private String lastName;

    public Student(int studentID, double ratingScore, String firstName, String lastName) {
        this.studentID = studentID;
        this.ratingScore = ratingScore;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public double getRatingScore() {
        return ratingScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setRatingScore(double ratingScore) {
        this.ratingScore = ratingScore;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\tStudent ID:\t").append(getStudentID())
                .append("\tRating Score:\t").append(getRatingScore())
                .append("\tFirst Name:\t").append(getFirstName())
                .append("\tLast Name:\t").append(getLastName());

        return string.toString();
    }

    public static void main(String[] args) {
        System.out.println("******************** STUDENT TESTING ********************");
        System.out.println("Initial student:");
        Student student = new Student(0, 90.00, "TestName", "TestSurname");
        System.out.println(student);
        System.out.println();

        System.out.println("Test setting and getting student data:");
        student.setStudentID(1);
        student.setRatingScore(91.01);
        student.setFirstName("Inessa");
        student.setLastName("Repeshko");
        System.out.println("\tStudent ID:\t\t" + student.getStudentID()
                + "\n\tRating Score:\t" + student.getRatingScore()
                + "\n\tFirst Name:\t\t" + student.getFirstName()
                + "\n\tLast Name:\t\t" + student.getLastName());
    }
}
