import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 5: 
                    System.out.println("Exiting program...");
                    System.exit(0);
                default: 
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = input.nextLine();
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        
        double marks;
        while (true) {
            System.out.print("Enter Marks: ");
            if (input.hasNextDouble()) {
                marks = input.nextDouble();
                input.nextLine();
                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Error: Marks must be between 0 and 100");
                }
            } else {
                System.out.println("Error: Please enter a valid number");
                input.nextLine(); 
            }
        }
        
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println("ID: " + s.getStudentId() + ", Name: " + s.getName() + ", Marks: " + s.getMarks() + ", Grade: " + s.calculateGrade());
        }
    }
}