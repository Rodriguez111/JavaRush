package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    private double averageGrade;
    private int course;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name, age);

        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }


    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }






    public void incAverageGrade(double delta){
        setAverageGrade(getAverageGrade()+delta);

    }

    private void averageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }


    public void setCourse(int course) {
        this.course = course;
    }

    public void setBeginningOfSession(Date data) {

        beginningOfSession = data;
    }

    public void setEndOfSession(Date data) {
        endOfSession = data;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }
}