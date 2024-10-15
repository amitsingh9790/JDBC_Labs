use StudentManagementSystem;
INSERT INTO Student (StudentID, FirstName, LastName, DateOfBirth, Gender, Email, Phone) VALUES
('2021022001','Akhilesh', 'Kumar', '2002-03-23','M', 'akhi83@gmail.com', '8736382398'), 
('2021022002','Rahul', 'Yaday', '2001-09-05','M', 'rahul2390@gmail.com', '1122382398'), 
('2021022003','Amit', 'Singh', '2001-12-25','M', 'amitsingh9790@gmail.com', '3333382398')
;
select * from student;

INSERT INTO Course (CourseID, CourseTitle, Credits) VALUES
('C1', 'Physics',22),
('C2', 'Chemisty', 21),
('C3', 'Math',20);

select*from course;

INSERT INTO Instructor (InstructorID, Email, FirstName, LastName) VALUES
('I111', 'arunsharma@gmail.com', 'Arun', 'Sharma'), 
('I222', 'sachin@gmail.com', 'Sachin', 'Singh'), 
('I333', 'raj343@gmail.com', 'Raj', 'Varma');
select * from instructor;

 
INSERT INTO Enrollment (EnrollmentID,StudentID, CourseID,InstructorID) VALUES
('E1001','2021022001','C1','I111'),
('E1002','2021022002','C2','I222'),
('E1003','2021022003','C3','I333');

SELECT * FROM Enrollment;

INSERT INTO Score
(ScoreID,StudentID,CourseID,CreditObtained,DateOfExam)VALUES
('S1001','2021022001','C1','15','2024-12-05'),
('S1002','2021022002','C2','14','2024-12-05'),
('S1003','2021022003','C3','15','2024-12-05');

SELECT * FROM Score;

INSERT INTO Feedback(StudentID,InstructorName,Feedback)VALUES
('2021022001','I111','Session was Amazing'),
('2021022002','I222','Session was Brilliant '),
('2021022003','I333', 'Session was Good');

SELECT * FROM Feedback;