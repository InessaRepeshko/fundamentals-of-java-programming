package task2;

class Human {
    private String firstName;
    private String lastName;
    private String sex;
    private int age;

    public Human(
            String firstName,
            String lastName,
            String sex,
            int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getSex() { return sex; }

    public int getAge() { return age; }

    @Override
    public String toString() {
        return "First Name:\t\t" + getFirstName() + "\n" +
                "Last Name:\t\t" + getLastName() + "\n" +
                "Sex:\t\t\t" + getSex() + "\n" +
                "Age:\t\t\t" + getAge() + "\n";
    }

    public void printData() {
        System.out.println(this);
    }
}
