//Holds information about a student and their courses in an array list

import java.io.Serializable;
import java.util.ArrayList;

class Student implements Serializable {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(String name) { this.name = name; }

    public void addCourse(Course c) { courses.add(c); }

    public ArrayList<Course> getCourses() { return courses; }

    public double getOverallPercentage() {
        if (courses.isEmpty()) return 0;
        double total = 0;
        for (Course c : courses)
            total += c.getPercentage();
        return total / courses.size();
    }

    public String getName() { return name; }
}