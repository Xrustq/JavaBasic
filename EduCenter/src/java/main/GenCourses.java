package main;

import main.entity.Course;
import main.entity.Curriculum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenCourses {

    private List<Course> courseList = new ArrayList<>();
    private List<Curriculum> curriculumList = new ArrayList<>();
    private Random random = new Random();

    {
        courseList.add(new Course("Технологии Java Servlets", 16));
        courseList.add(new Course("Обзор технологий Java", 8));
        courseList.add(new Course("Spring Framework", 32));
        courseList.add(new Course("Hibernate", 16));
        courseList.add(new Course("Технология JDBC", 8));
        courseList.add(new Course("Технология JAX", 8));
        courseList.add(new Course("Библиотеки commons", 8));
        courseList.add(new Course("Библиотека JFC/Swing", 16));

    }

    public Curriculum genCurriculum() {

        curriculumList.add(new Curriculum("J2EE Developer", genCource()));
        curriculumList.add(new Curriculum("Java Developer", genCource()));

        return curriculumList.get(random.nextInt(curriculumList.size()));
    }

    public List<Course> genCource() {

        List<Course> courceList = new ArrayList<>();
        int digit = random.nextInt(8) + 1;

        for (int i = 0; i < digit; i++) {
            Course course = courseList.get(random.nextInt(courseList.size()));
            if (!courceList.contains(course)) {
                courceList.add(course);
            }
        }
        return courceList;
    }

    public int[] rndMarks(Curriculum curriculum) {
        int[] array = new int[curriculum.getCourses().size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(5) + 1;
        }
        System.out.println();
        return array;
    }
}
