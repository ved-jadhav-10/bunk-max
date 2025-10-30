//Menu driven part of the attendance management system, connects everything together
/*
Made by -
Ved Jadhav - 124B1F059
Rehaan Shaikh - 124B1F067
Veerbhadra Mahant - 124B1F073
 */


import java.util.*;
import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        Student student = new Student(name);
        AttendanceManager manager = new AttendanceManager(student);

        AutoSaveThread autoSave = new AutoSaveThread(manager, student);
        autoSave.setDaemon(true);
        autoSave.start();

        int choice;
        do {
            System.out.println("\n===== Attendance Management System =====");
            System.out.println("1. Add Course");
            System.out.println("2. Update Attendance");
            System.out.println("3. Display Attendance");
            System.out.println("4. Save Data");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> manager.addCourse();
                case 2 -> manager.updateAttendance();
                case 3 -> manager.displayAttendance();
                case 4 -> {
                    try {
                        manager.saveData(student);
                        System.out.println("Data saved successfully!");
                    } catch (IOException e) {
                        System.out.println("Error saving data: " + e.getMessage());
                    }
                }
                case 5 -> System.out.println("Exiting");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}