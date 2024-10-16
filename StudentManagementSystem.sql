create database StudentManagementSystem;
use StudentManagementSystem;
CREATE TABLE Student (
StudentID VARCHAR(10) PRIMARY KEY,
FirstName VARCHAR(25) NOT NULL,
LastName VARCHAR(25) NOT NULL,
DateOfBirth DateTime NOT NULL,
Gender VARCHAR(25) NOT NULL,
Email VARCHAR(30) UNIQUE NOT NULL,
Phone VARCHAR(25) NOT NULL
);
CREATE TABLE Course (
CourseID VARCHAR(10) PRIMARY KEY,
CourseTitle VARCHAR(30) NOT NULL,
Credits INT NOT NULL
);
CREATE TABLE Instructor (
InstructorID VARCHAR(10) PRIMARY KEY,
Email VARCHAR(30) UNIQUE NOT NULL,
FirstName VARCHAR(30) NOT NULL,
LastName VARCHAR(30)
);
CREATE TABLE Enrollment (
EnrollmentID VARCHAR(10) PRIMARY KEY,
StudentID VARCHAR(10) NOT NULL,
CourseID VARCHAR(10) NOT NULL,
InstructorID VARCHAR(10) NOT NULL,
FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
FOREIGN KEY (CourseID) REFERENCES Course(CourseID),
FOREIGN KEY (InstructorID) REFERENCES Instructor(InstructorID)
);
CREATE TABLE Score(
ScoreID VARCHAR(10) PRIMARY KEY,
StudentID VARCHAR(10) NOT NULL,
CourseID VARCHAR(10) NOT NULL,
FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
FOREIGN KEY (CourseID) REFERENCES Course(CourseID),
CreditObtained VARCHAR(10) NOT NULL,
DateOfExam DateTime NOT NULL
);

CREATE TABLE Feedback(
FeedbackID INT Auto_Increment PRIMARY KEY,
StudentID VARCHAR(10) NOT NULL,
InstructorName VARCHAR(10) NOT NULL,
Feedback VARCHAR(100) NOT NULL
);