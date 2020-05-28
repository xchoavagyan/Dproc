package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------------------MENU-------------------------");
        System.out.println(" We Are very Happy to see you in our School , HI HELLO ZDRASTVUITE BAREV");
        System.out.println("!!!ATANTION!!! PLEASE WRITE CORRECT FORMAT , OTHERWISE YOU WILL HAVE EXCEPTION");
        Scanner scanner = new Scanner(System.in);
        List<Student> allStudents = new ArrayList<Student>(10);
        boolean whileLoop = true;
        while (whileLoop) {
            System.out.println("----------------------------------------------------");
            System.out.println("If you want to input Student PRESS <<1>>");
            System.out.println("If you want to more than 4.0 Students average PRESS <<2>>");
            System.out.println("If you want to exit PRESS <<3>>");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("Please insert the number of Students you want to input");
                    int quantityOfStudents = Integer.parseInt(scanner.nextLine());
                    for (int j = 0; j < quantityOfStudents; j++) {
                        Student student = new Student();
                        System.out.println("Please Insert Student Full name");
                        student.setSurname(scanner.nextLine());
                        student.setInitials();
                        System.out.println("Please insert Student Group number");
                        student.setGroupId(Integer.parseInt(scanner.nextLine()));
                        int[] progressInput = new int[5];
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Please insert appraisal " + (i + 1));
                            progressInput[i] = Integer.parseInt(scanner.nextLine());
                        }
                        student.setProgress(progressInput);
                        allStudents.add(student);
                    }
                    allStudents.sort(Comparator.comparing(Student::getGroupId));
                    break;
                case 2:
                    ArrayList<Student> highQualityStudents = new ArrayList<>();
                    for (int i = 0; i < allStudents.size(); i++) {
                        double averageOfProgress = allStudents.get(i).getAverageOfProgress(allStudents.get(i).getProgress());
                        if (averageOfProgress > 4.0d) {
                            highQualityStudents.add(allStudents.get(i));
                        }
                    }
                    if (highQualityStudents.isEmpty()) {
                        System.out.println("Theere is no Good Students");
                    } else {
                        for (int i = 0; i < highQualityStudents.size(); i++) {
                            System.out.println(highQualityStudents.get(i));
                        }
                    }
                    break;
                case 3:
                    whileLoop = false;
                    break;
            }
        }
    }
}
