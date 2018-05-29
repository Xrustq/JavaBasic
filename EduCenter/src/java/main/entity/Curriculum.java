package main.entity;

import java.util.List;

public class Curriculum {
    private String curriculumName;
    private List<Course> courses;

    public Curriculum(String curriculumName, List<Course> courses) {
        this.curriculumName = curriculumName;
        this.courses = courses;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "curriculumName='" + curriculumName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
