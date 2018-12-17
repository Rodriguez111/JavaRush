package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    private String name;

    public University(String name, int age) {
        this.age = age;
        this.name = name;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() == averageGrade) {
                return students.get(i);
            }
        }
        //TODO:
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student bestStudent = students.get(0);

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > bestStudent.getAverageGrade()) {
                bestStudent = students.get(i);
            }

        }
        return bestStudent;
    }



    public Student getStudentWithMinAverageGrade(){
        Student worstStudent = students.get(0);

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < worstStudent.getAverageGrade()) {
                worstStudent = students.get(i);
            }

        }
        return worstStudent;
    }

    public void expel(Student student){
        students.remove(student);

    }



}


