import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        studentmanager studentManager = new studentmanager();
        menu menu = new menu();

        System.out.println("Student Management Application");
        System.out.print("Press 1 to launch menu. To exit press any other key: ");

        String input = scanner.nextLine();

        if ("1".equals(input)) {
            while (true) {
                menu.displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        studentManager.saveStudent(scanner);
                        break;
                    case 2:
                        studentManager.searchStudent(scanner);
                        break;
                    case 3:
                        studentManager.deleteStudent(scanner);
                        break;
                    case 4:
                        studentManager.printStudentReport();
                        break;
                    case 5:
                        System.out.println("Exit");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Exit.");
        }

        scanner.close();
    }
}