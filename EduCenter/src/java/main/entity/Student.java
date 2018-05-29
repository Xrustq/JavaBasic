package main.entity;

import java.time.LocalDate;
import java.util.Arrays;


public class Student {
    private String name;
    private Curriculum curriculum;
    private LocalDate startDate;
    private int[] marks;

    public Student(String name, Curriculum curriculum, LocalDate startDate, int[] marks) {
        this.name = name;
        this.curriculum = curriculum;
        this.startDate = startDate;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", curriculum=" + curriculum +
                ", startDate='" + startDate + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
