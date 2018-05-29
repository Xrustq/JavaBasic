package main;


import main.entity.Curriculum;
import main.entity.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Calculations calculations = new Calculations();
        List<Student> students = new ArrayList<>();
        GenCourses genCourses = new GenCourses();
        Student student1;
        Student student2;

        Curriculum curriculum1 = genCourses.genCurriculum();
        Curriculum curriculum2 = genCourses.genCurriculum();

        student1 = new Student("Nikolay Nikolaev", curriculum1, LocalDate.of(2018, Month.MAY, 21), genCourses.rndMarks(curriculum1));
        student2 = new Student("Igor Igorev", curriculum2, LocalDate.of(2018, Month.MAY, 14), genCourses.rndMarks(curriculum2));

        students.add(student1);
        students.add(student2);

        for (Student student : students) {
            System.out.printf("%s - До окончания обучения по программе %s осталось %d ч. Средний балл %.1f. %s \n",
                    student.getName(), student.getCurriculum().getCurriculumName(), Calculations.amountOfDaysTheEnd(student) * 8, Calculations.averageMarks(student),
                    (calculations.verificationOfProgress(student)) ? "Отчислить." : "Может продолжать обучение.");
        }

        Calculations.sortByAverageMark(students);
        Calculations.sortByDaysTheEnd(students);
    }
}

