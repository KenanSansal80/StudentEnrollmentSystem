/**
 * Programmer: Kenan Nuray
 
 * Date: July 21, 2023
 * 
 * Files:PA2, Student
 */

// Imports
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class NurayK001PA2 {

    // Constant values
    public static final int NUM_STUDENTS = 4;
    public static final int CHANCE_OF_DROPPING = 3;
    public static final int DROP_A_COURSE = 1;

    public static void main(String[] args) {
        String fName, lName, classification;
        int id, index, drop;
        int numStudents = 0;
        Student[] allStudents = new Student[NUM_STUDENTS];

        Random rand = new Random();
        Scanner inputFile = null;

        try {
            inputFile = new Scanner(new File("Names.txt"));

            // Reading student information from the input file and creating Student objects
            while (inputFile.hasNext() && numStudents < NUM_STUDENTS) {
                fName = readFirstName(inputFile);
                lName = readLastName(inputFile);
                id = readID(inputFile);
                classification = readClassification(inputFile);

                allStudents[numStudents] = new Student(fName, lName, id, classification);
                numStudents++;
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Error: File not found.%n");
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
        }

        System.out.printf("The students:%n");
        for (int i = 0; i < numStudents; i++) {
            // Printing the student information
            System.out.printf("Student: %s %s %d %s%n", allStudents[i].getFirstName(), allStudents[i].getLastName(),
                    allStudents[i].getID(), allStudents[i].getClassification());
        }

        System.out.println();
        System.out.printf("The student's courses:%n");
        for (int i = 0; i < numStudents; i++) {
            // Enrolling students in courses
            allStudents[i].enrollStudent();
        }

        for (int i = 0; i < numStudents; i++) {
            // Printing student's enrolled courses
            allStudents[i].printStudentCourses();
            System.out.println();
        }

        System.out.printf("%nAgain, the student's courses:%n");
        for (int i = 0; i < numStudents; i++) {
            // Randomly dropping a course for each student
            drop = rand.nextInt(CHANCE_OF_DROPPING);
            if (drop == DROP_A_COURSE) {
                allStudents[i].dropCourse();
            }
        }

        for (int i = 0; i < numStudents; i++) {
            // Printing student's courses after potential drop
            allStudents[i].printStudentCourses();
            System.out.println();
        }

        goodBye();
    } // end main method 

    // Read the first name from the input file
    public static String readFirstName(Scanner inputFile) {
        String firstName = inputFile.next();
        return firstName;
    }

    // Read the last name from the input file
    public static String readLastName(Scanner inputFile) {
        String lastName = inputFile.next();
        return lastName;
    }

    // Read the student ID from the input file
    public static int readID(Scanner inputFile) {
        int id = inputFile.nextInt();
        return id;
    }

    // Read the student classification from the input file
    public static String readClassification(Scanner inputFile) {
        String classification = inputFile.next();
        return classification;
    }

    // Print the end of program message
    public static void goodBye() {
        System.out.printf("This program was written by Kenan Nuray.%n" +
        "End of program.%n");

    }
} // end class NurayK001PA2

class Student {
    private final int COURSE_NUM = 6;
    private final int FIRST_OR_SECOND = 2;
    private final int POSSIBLE_COURSES = 2;

    private String firstName;
    private String lastName;
    private String classification;
    private int id;
    private String[] courses = new String[COURSE_NUM];
    private String[] studentCourses = new String[POSSIBLE_COURSES];
    private String firstCourse;
    private String secondCourse;

    public Student(String firstNameIn, String lastNameIn, int idIn, String classificationIn) {
        setFirstName(firstNameIn);
        setLastName(lastNameIn);
        setID(idIn);
        setClassification(classificationIn);
        setCourses();
    }

    // Set the student's first name
    public void setFirstName(String firstNameIn) {
        firstName = firstNameIn;
    }

    // Set the student's last name
    public void setLastName(String lastNameIn) {
        lastName = lastNameIn;
    }

    // Set the student's ID
    public void setID(int idIn) {
        id = idIn;
    }

    // Set the student's classification
    public void setClassification(String classificationIn) {
        classification = classificationIn;
    }

    // Set the available courses
    public void setCourses() {
        courses[0] = "MAT 1093 Precalculus";
        courses[1] = "ENG 2413 Editing";
        courses[2] = "CHE 1073 Basic Chemistry";
        courses[3] = "PHI 2043 Introductory Logic";
        courses[4] = "BIO 1404 Biosciences I";
        courses[5] = "AST 1013 Introduction to Astronomy";
    }

    // Get the student's first name
    public String getFirstName() {
        return firstName;
    }

    // Get the student's last name
    public String getLastName() {
        return lastName;
    }

    // Get the student's ID
    public int getID() {
        return id;
    }

    // Get the student's classification
    public String getClassification() {
        return classification;
    }

    // Enroll the student in courses
    public void enrollStudent() {
        int first, second;
        Random rand = new Random();

        first = rand.nextInt(COURSE_NUM);
        second = rand.nextInt(COURSE_NUM);

        while (second == first) {
            second = rand.nextInt(COURSE_NUM);
        }

        studentCourses[0] = courses[first];
        studentCourses[1] = courses[second];
    }

    // Print the student's enrolled courses
    public void printStudentCourses() {
        for (int i = 0; i < POSSIBLE_COURSES; i++) {
            System.out.printf("Student #%d course: %s%n", id, studentCourses[i]);
        }
    }

    // Drop a course for the student
    public void dropCourse() {
        int dropThisCourse;
        Random rand = new Random();

        dropThisCourse = rand.nextInt(FIRST_OR_SECOND);
        studentCourses[dropThisCourse] += " (DROPPED)";
    }
} // End of class Student

  

