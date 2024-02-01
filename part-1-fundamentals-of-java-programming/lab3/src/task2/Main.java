package task2;

public class Main {
    public static void main(String[] args) {
        Human human = new Human(
                "Inessa",
                "Repeshko",
                "Female",
                25);
        Citizen citizen = new Citizen(
                "Inessa",
                "Repeshko",
                "Female",
                25,
                "Ukraine",
                "Ukrainian");
        Student student = new Student(
                "Inessa",
                "Repeshko",
                "Female",
                25,
                "Ukraine",
                "Ukrainian",
                "NTU \"KhPI\"",
                121,
                "KN-222a",
                2020);
        Employee employee = new Employee(
                "Inessa",
                "Repeshko",
                "Female",
                25,
                "Ukraine",
                "Ukrainian",
                "\"Software\"",
                "Development",
                "Junior Developer",
                1);
        Human[] persons = {human, citizen, student, employee};

        for (Human person : persons) {
            System.out.println("Personal data:");
            person.printData();
        }
    }
}
