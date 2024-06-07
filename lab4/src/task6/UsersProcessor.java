package task6;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class UsersProcessor {
    public static SortedMap<String, String> createUsers() {
        SortedMap<String, String> users = new TreeMap<>();
        users.put("David", "Lmn2");
        users.put("Henry", "S3cretPwd");
        users.put("Frank", "1a2b3c4d");
        users.put("Alice", "Abcd5");
        users.put("Charlie", "Pqr7890");
        users.put("Grace", "Jkl0pqr");
        users.put("Isabel", "9AbCdEfG");
        users.put("Emily", "Ghi456");
        users.put("Jack", "XYZ45678");
        users.put("Bob", "Xyz123");

        return users;
    }

    public static void findUsersWithPasswordLengthMoreThanSix(SortedMap<String, String> users) {
        if (users.isEmpty()) {
            System.out.println("There are no users with passwords longer than 6 letters.");
        }

        System.out.println("Users with passwords longer than 6 letters:");

        for (Map.Entry<?, String> entry : users.entrySet()) {
            if (entry.getValue().length() > 6) {
                System.out.println("\tUsername:\t\'" + entry.getKey() + "\'  \tPassword:\t\'" + entry.getValue() + "\'");
            }
        }
    }

    public static void main(String[] args) {
        findUsersWithPasswordLengthMoreThanSix(createUsers());
    }
}
