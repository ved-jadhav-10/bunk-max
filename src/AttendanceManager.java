//AttendanceManager class that implements AttendanceOperations (interface) and extends FileHandler
//This part also does exception handling for stack overflow and general exceptions

import java.io.*;
import java.util.*;

class AttendanceManager extends FileHandler implements AttendanceOperations {
    private Student student;
    private Stack<String> undoStack = new Stack<>();

    public AttendanceManager(Student student) {
        this.student = student;
    }

    @Override
    public void addCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course name: ");
        String name = sc.nextLine();
        System.out.print("Enter total classes: ");
        int total = sc.nextInt();
        System.out.print("Enter attended classes: ");
        int attended = sc.nextInt();
        student.addCourse(new Course(name, total, attended));
        System.out.println("Course added successfully!");
    }

    @Override
    public void updateAttendance() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Select course number to update:");
            ArrayList<Course> list = student.getCourses();
            for (int i = 0; i < list.size(); i++)
                System.out.println((i + 1) + ". " + list.get(i).getCourseName());
            int choice = sc.nextInt() - 1;

            if (choice < 0 || choice >= list.size())
                throw new IndexOutOfBoundsException("Invalid course choice.");

            System.out.print("Enter additional attended classes: ");
            int a = sc.nextInt();
            System.out.print("Enter additional classes conducted: ");
            int t = sc.nextInt();

            undoStack.push(list.get(choice).getCourseName());
            if (undoStack.size() > 5) throw new StackOverflowError("Undo stack overflow!");

            list.get(choice).updateAttendance(a, t);
            System.out.println("Attendance updated successfully!");

        } catch (StackOverflowError e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public void displayAttendance() {
        ArrayList<Course> list = student.getCourses();
        if (list.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course c : list) {
            System.out.printf("%s: %.2f%% - %s\n",
                c.getCourseName(), c.getPercentage(), c.getAdvice());
        }
        System.out.printf("Overall Attendance: %.2f%%\n", student.getOverallPercentage());
    }

    @Override
    void saveData(Student student) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("attendance.dat"));
        oos.writeObject(student);
        oos.close();
    }

    @Override
    Student loadData() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("attendance.dat"));
        Student s = (Student) ois.readObject();
        ois.close();
        return s;
    }
}
