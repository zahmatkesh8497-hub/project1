import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static boolean validateNationalCode(String code) {
        if (code == null || code.length() != 10) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (code.charAt(i) - '0') * (10 - i);
        }
        int checkDigit = (11 - (sum % 11)) % 10;
        return checkDigit == (code.charAt(9) - '0');
    }

    public static void main(String[] args) {
        Map<String, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Student Management System (JDK 25) ---");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Search by National Code");
            System.out.println("3. Remove Student by National Code");
            System.out.println("4. Edit Student Name by National Code");
            System.out.println("5. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter National Code: ");
                    String code = scanner.nextLine();

                    if (validateNationalCode(code)) {
                        studentMap.put(code, name);
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Invalid National Code. Please try again.");
                    }
                }
                case "2" -> {
                    System.out.print("Enter National Code to search: ");
                    String searchCode = scanner.nextLine();
                    String result = studentMap.getOrDefault(searchCode, "Student not found.");
                    System.out.println("Result: " + result);
                }
                case "3" -> {
                    System.out.print("Enter National Code to remove: ");
                    String removeCode = scanner.nextLine();
                    if (studentMap.containsKey(removeCode)) {
                        studentMap.remove(removeCode);
                        System.out.println("Student removed successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case "4" -> {
                    System.out.print("Enter National Code to edit: ");
                    String editCode = scanner.nextLine();
                    if (studentMap.containsKey(editCode)) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        studentMap.put(editCode, newName);
                        System.out.println("Student name updated successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case "5" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}