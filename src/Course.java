//This is where all our course related info is, and the logic behind it

//Serializable indicates a class's instances can be converted into a byte stream and later restored
//Good for simple local caching, deep-copy via serialize-deserialize, or
//quick persistence of object graphs in desktop apps/educational projects
import java.io.Serializable;

class Course implements Serializable {
    private String courseName;
    private int totalClasses;
    private int attendedClasses;

    public Course(String courseName, int totalClasses, int attendedClasses) {
        this.courseName = courseName;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public void updateAttendance(int attended, int total) {
        this.attendedClasses += attended;
        this.totalClasses += total;
    }

    public double getPercentage() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    public String getCourseName() { return courseName; }
    public int getTotalClasses() { return totalClasses; }
    public int getAttendedClasses() { return attendedClasses; }

    public String getAdvice() {
        double percent = getPercentage();
        if (percent < 75) {
            int needed = (int)Math.ceil((0.75 * totalClasses - attendedClasses) / (1 - 0.75));
            return "Attend " + needed + " more classes to reach 75%.";
        } else {
            int canBunk = (int)Math.floor((attendedClasses - 0.75 * totalClasses) / 0.75);
            return "You can safely miss " + canBunk + " classes.";
        }
    }
}