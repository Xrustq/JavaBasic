package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static main.Calculations.EndDate;
import static main.Calculations.averageMarks;
import static main.Calculations.getCourseDuration;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student student;

        Curriculum curriculum;

        List<Course> courses = new ArrayList<>();

        int[] marks = {4, 5, 5};

        Date date = new Date();

        curriculum = new Curriculum("J2EE Developer", courses);

        courses.add(new Course("Java Servlets", 8));
        courses.add(new Course("Spring Framework", 16));

        student = new Student("Ivan", curriculum, date, marks);

        students.add(student);

        System.out.println(students);

        //Getting the average of one student
        System.out.printf("Средний балл " + student.getName() + " " + "%.1f" + " балла." + "\n", averageMarks(student));

        System.out.println(EndDate(student));

        System.out.printf(String.valueOf(getCourseDuration(student)));

    }
}

