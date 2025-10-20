//This is an abstract class for file handling (we will extend this for attendance management)
//Basically we are saving and loading data

import java.io.*;

public abstract class FileHandler {
    abstract void saveData(Student student) throws IOException;
    abstract Student loadData() throws IOException, ClassNotFoundException;
}