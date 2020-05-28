package com.company;

import java.util.Arrays;

public class Student {

    private String surname;
    private String initials;
    private int groupId;
    private int[] progress = new int[5];

    public Student(String surname, int groupId, int[] progress) {
        this.surname = surname;
        String init = null;
        String[] initialsWords = surname.split(" ");
        for (int i = 0; i < initialsWords.length; i++) {
            char initial = initialsWords[i].charAt(0);
            init = Character.toUpperCase(initial) + ".";
        }
        this.initials = init;
        this.groupId = groupId;
        this.progress = progress;
    }

    public Student() {
    }

    public double getAverageOfProgress(int[] progress) {
        int sum = 0;
        for (int i = 0; i < progress.length; i++) {
            sum += progress[i];
        }
        double average = sum / progress.length;
        return average;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials() {
        String init = " ";
        String[] initialsWords = surname.split(" ");
        for (int i = 0; i < initialsWords.length; i++) {
            char initial = initialsWords[i].charAt(0);
            init += (Character.toUpperCase(initial) + ".");
        }
        this.initials = init;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int[] getProgress() {
        return progress;
    }

    public void setProgress(int[] progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (groupId != student.groupId) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (initials != null ? !initials.equals(student.initials) : student.initials != null) return false;
        return Arrays.equals(progress, student.progress);
    }

    @Override
    public int hashCode() {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + (initials != null ? initials.hashCode() : 0);
        result = 31 * result + groupId;
        result = 31 * result + Arrays.hashCode(progress);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", initials='" + initials + '\'' +
                ", groupId=" + groupId +
                ", progress=" + Arrays.toString(progress) +
                '}';
    }
}
