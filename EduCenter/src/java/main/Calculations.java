package main;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Calculations {

    public int beforeTheEnd() {
        return 0;
    }

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

    public static int getCourseDuration(Student student) {
        double duration = 0;
        List<Course> courses = student.getCurriculum().getCourses();

        for (Course course : courses)
            duration += course.getDurability();

        double days = duration / 8;

        return (int) Math.ceil(days);
    }

    public static int DaysUntilTheEnd(Student student) {
        return getCourseDuration(student) - student.getMarks().length;
    }

    //Calculates the date when training ends
    public static Calendar EndDate(Student student) {
        Calendar date2 = Calendar.getInstance();
        date2.setTime(student.getStartDate());
        System.out.println(date2);
        date2.add(Calendar.DAY_OF_YEAR, getCourseDuration(student));
        return date2;
    }
}
