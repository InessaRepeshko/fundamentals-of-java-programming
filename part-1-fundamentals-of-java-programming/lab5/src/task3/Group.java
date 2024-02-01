package task3;

public class Group {
    private String groupID;
    private int specialtyID;
    private Student[] students;

    public Group(String groupID, int specialtyID) {
        this.groupID = groupID;
        this.specialtyID = specialtyID;
    }

    public Group(String groupID, int specialtyID, Student... students) {
        this.groupID = groupID;
        this.specialtyID = specialtyID;
        this.students = students;
    }

    public String getGroupID() {
        return groupID;
    }

    public int getSpecialtyID() {
        return specialtyID;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public void setSpecialtyID(int specialtyID) {
        this.specialtyID = specialtyID;
    }

    public void setStudents(Student... students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\tGroup ID:\t").append(getGroupID())
                .append("\n\tSpecialty ID:\t").append(getSpecialtyID())
                .append("\n\tStudent list:\n");

        if (getStudents() == null || students.length == 0) {
            string.append("\t\tThere are no students.\n");
        } else {
            for (Student student : getStudents()) {
                string.append("\t").append(student).append("\n");
            }
        }

        return string.toString();
    }

    public static Group createTestGroup() {
        Student student1 = new Student(1, 87.05, "Anna", "Beregova");
        Student student2 = new Student(2, 83.28, "Vera", "Boyko");
        Student student3 = new Student(3, 85.92, "Oleg", "Stryzh");
        Student student4 = new Student(4, 88.75, "Fedor", "Poychenko");
        Student student5 = new Student(5, 86.63, "Tyler", "Fog");

        return new Group("KN-222f",
                121,
                student1, student2, student3, student4, student5);
    }

    public static void main(String[] args) {
        System.out.println("******************** GROUP TESTING ********************");
        System.out.println("Test creating group with parametrized constructor without students:");
        Group firstGroup = new Group("KN-222a", 121);
        System.out.println(firstGroup);

        System.out.println("Test creating group with parametrized constructor with students:");
        Group secondGroup = createTestGroup();
        System.out.println(secondGroup);

        System.out.println("Test setting and getting group data:");
        secondGroup.setGroupID("AB-123q");
        secondGroup.setSpecialtyID(72);
        Student student1 = new Student(10, 90.00, "Aleksandr", "Frank");
        Student student2 = new Student(11, 81.20, "Alevtina", "Prud");
        secondGroup.setStudents(student1, student2);
        System.out.println("\tGroup ID:\t" + secondGroup.getGroupID()
                + "\n\tSpecialty ID:\t" + secondGroup.getSpecialtyID()
                + "\n\tStudent list:");
        for (Student student : secondGroup.getStudents()) {
            System.out.println("\t" + student);
        }
    }
}
