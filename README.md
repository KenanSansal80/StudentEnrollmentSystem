Student Enrollment System

Description

This Java-based student enrollment system reads student data from a file (Names.txt), assigns random courses to students, and simulates course drops. The program utilizes object-oriented programming principles with file handling and randomness.

Features

Reads student details (first name, last name, ID, classification) from a file.

Randomly assigns two courses from a predefined course list.

Simulates the possibility of dropping a course based on probability.

Displays student details and enrolled courses before and after course dropping.

Technologies Used

Java

File Handling

Randomization

How to Run

Prerequisites

Ensure you have the following installed:

Java JDK

Steps

Clone the Repository:

git clone https://github.com/your-username/StudentEnrollmentSystem.git
cd StudentEnrollmentSystem

Compile the Java Files:

javac NurayK001PA2.java

Run the Program:

java NurayK001PA2

File Structure

StudentEnrollmentSystem/
│── NurayK001PA2.java      # Main Java file
│── Student.java           # Student class
│── Names.txt              # Input file containing student data
│── README.md              # Project documentation

Example Output

The students:
Student: Alice Johnson 1001 Freshman
Student: Bob Smith 1002 Sophomore
...

The student's courses:
Student #1001 course: MAT 1093 Precalculus
Student #1001 course: BIO 1404 Biosciences I
...

Again, the student's courses:
Student #1001 course: MAT 1093 Precalculus (DROPPED)
Student #1001 course: BIO 1404 Biosciences I
...

This program was written by Kenan Nuray.
End of program.

License

This project is open-source and available under the MIT License.

Author

Kenan Nuray
