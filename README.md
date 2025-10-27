## bunk-max

A mini Java console application project to help students track attendance and calculate how many more classes they can bunk while maintaining a target attendance percentage.

This was made to mainly learn Object Oriented Programming concepts through a fun miniproject.

## Project Structure

The `src/` directory contains the main Java source files:

- `AttendanceManager.java` - high-level logic for managing attendance records and interacting with other components.
- `AttendanceOperations.java` - operations for updating and computing attendance statistics.
- `AutoSaveThread.java` - background thread that periodically saves data to disk.
- `Course.java` - model class representing a course (name, attendance counts, etc.).
- `FileHandler.java` - utilities for saving/loading application data to/from files.
- `MainApp.java` - application entry point with the main method and user interaction loop.
- `Student.java` - model class representing a student and their attendance data.

There is also a `bin/` directory which can contain compiled `.class` files and a `lib/` directory for any external libraries (not required for this project).

## Requirements

- Java Development Kit (JDK) 8 or newer installed.

## What it does

- Lets you add courses and record attendance (present/absent).
- Calculates current attendance percentage for each course.
- Computes how many classes you can still bunk while staying above a target percentage.
- Periodically autosaves data to disk so you won't lose progress between runs. 
