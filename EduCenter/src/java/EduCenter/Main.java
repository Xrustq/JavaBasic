package EduCenter;


import EduCenter.entity.Curriculum;
import EduCenter.entity.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Calculations calculations = new Calculations();
        List<Student> students = new ArrayList<>();
        Generators generators = new Generators();
        Student student1;
        Student student2;
        Student student3;
        Student student4;

        Curriculum curriculum1 = generators.genCurriculum();
        Curriculum curriculum2 = generators.genCurriculum();
        Curriculum curriculum3 = generators.genCurriculum();
        Curriculum curriculum4 = generators.genCurriculum();

        student1 = new Student("Nikolay Nikolaev", curriculum1, LocalDate.of(2018, Month.MAY, 21), generators.rndMarks(curriculum1));
        student2 = new Student("Igor Igorev", curriculum2, LocalDate.of(2018, Month.MAY, 14), generators.rndMarks(curriculum2));
        student3 = new Student("Ivan Ivanov", curriculum3, LocalDate.of(2018, Month.MAY, 11), generators.rndMarks(curriculum3));
        student4 = new Student("Petr Petrov", curriculum4, LocalDate.of(2018, Month.MAY, 17), generators.rndMarks(curriculum4));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        for (Student student : students) {
            System.out.printf("%s - До окончания обучения по программе %s осталось %d ч. Средний балл %.1f. %s \n",
                    student.getName(), student.getCurriculum().getCurriculumName(), Calculations.amountOfDaysTheEnd(student) * 8, Calculations.averageMarks(student),
                    (calculations.verificationOfProgress(student)) ? "Отчислить." : "Может продолжать обучение.");
        }

        Calculations.sortByAverageMark(students);
        Calculations.sortByDaysTheEnd(students);
        Calculations.checkGoodStudent(students);

    }
}

