//Separate thread for auto-saving attendance data every 100 seconds

class AutoSaveThread extends Thread {
    private AttendanceManager manager;
    private Student student;

    public AutoSaveThread(AttendanceManager manager, Student student) {
        this.manager = manager;
        this.student = student;
    }

    public void run() {
        while (true) {
            try {
                manager.saveData(student);
                Thread.sleep(100000); // auto-save every 100 sec
            } catch (Exception e) {
                System.out.println("Auto-save failed: " + e.getMessage());
            }
        }
    }
}
