package main;

import main.entity.Course;
import main.entity.Student;

import java.util.ArrayList;
import java.util.List;

class Calculations {

    public static double averageMarks(Student student) {
        double sum = 0;
        int length;

        int[] marks = student.getMarks();
        length = marks.length;

        for (int i = 0; i < length; i++) {
            sum = marks[i] + sum;
        }

        return sum / length;
    }

    //Продолжительность курса в днях
    public static int getCourseDuration(Student student) {
        double duration = 0;
        List<Course> courses = student.getCurriculum().getCourses();

        for (Course course : courses)
            duration += course.getDurability();

        double days = duration / 8;

        return (int) Math.ceil(days);
    }

    //Сколько осталось студенту до завершения курса
    public static int amountOfDaysTheEnd(Student student) {
        return (getCourseDuration(student) - student.getMarks().length);
    }

    //Расчет, имеет ли смысл студенту продолжать обучение
    public static boolean verificationOfProgress(Student student) {
        double allMarks = 0;
        for (int mark : student.getMarks()) {
            allMarks += mark;
        }
        return ((allMarks + amountOfDaysTheEnd(student) * 5) / getCourseDuration(student)) < 4.5;
    }

    //Сортировка по среднему баллу
    public static void sortByAverageMark(List<Student> students) {
        List<Student> sortedList = new ArrayList<>(students);

        sortedList.sort((o1, o2) -> {
            if (averageMarks(o1) > averageMarks(o2)) {
                return -1;
            }
            if (averageMarks(o1) < averageMarks(o2)) {
                return 1;
            }
            return 0;
        });

        System.out.print("\n\n Список студентов отсортированный по среднему баллу:\n");
        for (Student student : sortedList) {
            System.out.printf("\n %-20s средний балл %.1f.", student.getName(), averageMarks(student));
        }
    }


    public static void sortByDaysTheEnd(List<Student> students) {
        List<Student> sortedList = new ArrayList<>(students);

        sortedList.sort((o1, o2) -> {
            if (amountOfDaysTheEnd(o1) > amountOfDaysTheEnd(o2)) {
                return -1;
            }
            if (amountOfDaysTheEnd(o1) < amountOfDaysTheEnd(o2)) {
                return 1;
            }
            return 0;
        });

        System.out.print("\n\n Список студентов отсортированный по времени до окончания обучения:\n");
        for (Student student : sortedList) {
            System.out.printf("\n %-20s до конца обучения осталось %s часов.", student.getName(), amountOfDaysTheEnd(student) * 8);
        }
    }


    public static void goodStudent(List<Student> students) {
        System.out.print("\n\n Есть вероятность, что не будет отчислен: \n\n");
        for (Student student : students) {
            if (!verificationOfProgress(student)) {
                System.out.printf(" %s" , student.getName());
            }
        }
    }
}
