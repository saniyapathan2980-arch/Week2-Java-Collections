import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: showStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // ADD
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        list.add(new Student(id, name, course));
        System.out.println("Student Added!");
    }

    // DISPLAY
    public static void showStudents() {
        if (list.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    // SEARCH
    public static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found");
    }

    // UPDATE
    public static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter new course: ");
                s.setCourse(sc.nextLine());

                System.out.println("Student Updated!");
                return;
            }
        }
        System.out.println("Student not found");
    }

    // DELETE
    public static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.getId() == id) {
                list.remove(s);
                System.out.println("Student Deleted!");
                return;
            }
        }
        System.out.println("Student not found");
    }
}
