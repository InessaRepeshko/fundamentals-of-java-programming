package task2;

class Citizen extends Human {
    private String country;
    private String citizenship;

    public Citizen(
            String firstName,
            String lastName,
            String sex,
            int age,
            String country,
            String citizenship) {
        super(firstName, lastName, sex, age);
        this.country = country;
        this.citizenship = citizenship;
    }

    public String getCountry() { return country; }

    public String getCitizenship() { return citizenship; }

    @Override
    public String toString() {
        return super.toString() +
                "Country:\t\t" + getCountry() + "\n" +
                "Citizenship:\t" + getCitizenship() + "\n";
    }

    @Override
    public void printData() {
        System.out.println(this);
    }
}
