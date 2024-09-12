import java.util.ArrayList;
import java.util.Scanner;

public class studentmanager {
    public static ArrayList<String>[] students = new ArrayList[5];

    public studentmanager() {
        for (int i = 0; i < students.length; i++) {
            students[i] = new ArrayList<>();
        }
    }
    public void saveStudent(Scanner scanner) {
        System.out.println("\nSAVE STUDENT");
        System.out.println("------------------------------------");

        System.out.print("Enter student ID: ");
        students[0].add(scanner.nextLine());

        System.out.print("Enter student name: ");
        students[1].add(scanner.nextLine());
        // 1.3: this if for validating age. using while loop and try and catch.
        while (true) {
            System.out.println("Age; equal to or older than 16");
            String ageInput = scanner.nextLine();
            try {
                int age = Integer.parseInt(ageInput);
                if(age >= 16) {
                    students[2].add(ageInput);
                    break;
                }else {
                    System.out.println("Invalid age. Must be 16 years or older.");
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid age. enter a valid age.");
            }
        }
        System.out.print("Enter student email: ");
        students[3].add(scanner.nextLine());

        System.out.print("Enter student course: ");
        students[4].add(scanner.nextLine());

        System.out.println("\nYour Information has been Captured.");

        System.out.print("Student captured successfully! Enter 1 to launch menu. Any other key to exit: ");
        if (!"1".equals(scanner.nextLine())) {
            System.out.println("Exit");
            System.exit(0);
        }
    }

    public void searchStudent(Scanner scanner) {
        // Placeholder for searching a student
        System.out.println("Search for a student.");
        System.out.println("Enter Student ID:");
        String StudID = scanner.nextLine();

        boolean studentFound = false;
        for(int i =0; i <students[0].size();i++) {
            if (students[0].get(i).equals(StudID)) {
                System.out.println("Student ID: " + students[0].get(i));
                System.out.println("Name: " + students[1].get(i));
                System.out.println("Age: " + students[2].get(i));
                System.out.println("Email: " + students[3].get(i));
                System.out.println("Course: " + students[4].get(i));
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Error: No student found with the ID " + StudID);
        }
    }

    public void deleteStudent(Scanner scanner) {
        // Placeholder for deleting a student
        System.out.println("Delete a Student.");
        System.out.println("Enter studentID to delete: ");
        String studentID = scanner.nextLine();

        boolean studentDelete = false;
        for (int i = 0; i < students[0].size();i++) {
            if(students[0].get(i).equals(studentID)) {
                students[1].remove(i);
                students[2].remove(i);
                students[3].remove(i);
                students[4].remove(i);
                studentDelete = true;
                System.out.println("Student with ID" + studentID);
                break;
            }
        }
        if(!studentDelete) {
            System.out.println("Invalid: No student with that ID.");
        }
    }

    public void printStudentReport() {
        System.out.println("\nSTUDENT REPORT");

        if (students[0].isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (int i = 0; i < students[0].size(); i++) {
                System.out.println("Student ID: " + students[0].get(i));
                System.out.println("Name: " + students[1].get(i));
                System.out.println("Age: " + students[2].get(i));
                System.out.println("Email: " + students[3].get(i));
                System.out.println("Course: " + students[4].get(i));
            }
        }

        System.out.print("Enter 1, return to menu: ");
        Scanner scanner = new Scanner(System.in);
        if (!"1".equals(scanner.nextLine())) {
            System.out.println("Exit.");
            System.exit(0);
        }
    }

    public void saveStudent(String ID, String name, String age, String email, String course) {
        students[0].add(ID);
        students[1].add(name);
        students[2].add(age);
        students[3].add(email);
        students[4].add(course);
    }

    public void searchStudent(String ID) {
    }

    public void deleteStudent(String ID) {
    }
}

