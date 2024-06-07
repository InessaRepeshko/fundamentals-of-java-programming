package task2;

class Employee extends Citizen {
    private String company;
    private String department;
    private String position;
    private int yearsOfService;

    public Employee(
            String firstName,
            String lastName,
            String sex,
            int age,
            String country,
            String citizenship,
            String company,
            String department,
            String position,
            int yearsOfService) {
        super(firstName, lastName, sex, age, country, citizenship);
        this.company = company;
        this.department = department;
        this.position = position;
        this.yearsOfService = yearsOfService;
    }

    public String getCompany() { return company; }

    public String getDepartment() { return department; }

    public String getPosition() { return position; }

    public int getYearsOfService() { return yearsOfService; }

    @Override
    public String toString() {
        return super.toString() +
                "Company:\t\t" + getCompany() + "\n" +
                "Department:\t\t" + getDepartment() + "\n" +
                "Position:\t\t" + getPosition() + "\n" +
                "Service(years):\t" + getYearsOfService() + "\n";
    }

    @Override
    public void printData() {
        System.out.println(this);
    }
}
