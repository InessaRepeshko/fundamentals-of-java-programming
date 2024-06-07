package task2;

class Student extends Citizen {
    private String university;
    private int specialityID;
    private String groupID;
    private int enteringYear;

    public Student(
            String firstName,
            String lastName,
            String sex,
            int age,
            String country,
            String citizenship,
            String university,
            int specialityID,
            String groupID,
            int enteringYear) {
        super(firstName, lastName, sex, age, country, citizenship);
        this.university = university;
        this.specialityID = specialityID;
        this.groupID = groupID;
        this.enteringYear = enteringYear;
    }

    public String getUniversity() { return university; }

    public int getSpecialityID() { return specialityID; }

    public String getGroupID() { return groupID; }

    public int getEnteringYear() { return enteringYear; }

    @Override
    public String toString() {
        return super.toString() +
                "University:\t\t" + getUniversity() + "\n" +
                "Speciality ID:\t" + getSpecialityID() + "\n" +
                "Group ID:\t\t" + getGroupID() + "\n" +
                "Entering Year:\t" + getEnteringYear() + "\n";
    }

    @Override
    public void printData() {
        System.out.println(this);
    }
}
