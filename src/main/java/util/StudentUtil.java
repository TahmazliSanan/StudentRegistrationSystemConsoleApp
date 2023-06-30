/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import beans.Student;
import project.Config;

/**
 *
 * @author user
 */
public class StudentUtil {

    public static Student fillStudent() {
        String name = InputUtil.requiredText("Enter the name:");
        String surname = InputUtil.requiredText("Enter the surname:");
        int age = InputUtil.requiredNumber("Enter the age:");
        String className = InputUtil.requiredText("Enter the class name:");

        Student student = new Student(name, surname, age, className);
        return student;
    }

    public static void printRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student student = Config.students[i];
            System.out.println((i + 1) + "." + student.showInfo());
        }
    }

    public static void registerStudent() {
        int count = InputUtil.requiredNumber("How many student will you add?");
        Config.students = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".register:");
            Config.students[i] = StudentUtil.fillStudent();
        }
        System.out.println("Registration completed successfully!");
        StudentUtil.printRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requiredText("Type the name, surname or class name:");
        Student[] foundedStudents = findStudents(text);
        for (int i = 0; i < foundedStudents.length; i++) {
            System.out.println(foundedStudents[i].showInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student student = Config.students[i];
            if (student.getName().contains(text)
                    || student.getSurname().contains(text)
                    || student.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int found = 0;

        for (int i = 0; i < Config.students.length; i++) {
            Student student = Config.students[i];
            if (student.getName().contains(text)
                    || student.getSurname().contains(text)
                    || student.getClassName().contains(text)) {
                result[found++] = student;
            }
        }
        return result;
    }

    public static void updateStudentWithSameObject() {
        StudentUtil.printRegisteredStudents();
        int index = InputUtil.requiredNumber("Which person do you want to change info?");
        System.out.println("Enter the new data:");

        // yeni bir obyekt yaranmir
        Student selectedStudent = Config.students[index - 1];
        String changeParameters = InputUtil.requiredText("'name', 'surname', 'age', 'class name'");

        if (changeParameters.contains("'name'")) {
            selectedStudent.setName(InputUtil.requiredText("Name:"));
        }
        if (changeParameters.contains("'surname'")) {
            selectedStudent.setSurname(InputUtil.requiredText("Surname:"));
        }
        if (changeParameters.contains("'age'")) {
            selectedStudent.setAge(InputUtil.requiredNumber("Age:"));
        }
        if (changeParameters.contains("'class name'")) {
            selectedStudent.setClassName(InputUtil.requiredText("Class name:"));
        }
    }

    public static void updateStudentWithNewObject() {
        StudentUtil.printRegisteredStudents();
        int index = InputUtil.requiredNumber("Which person do you want to change info?");
        System.out.println("Enter the new data:");

        // yeni bir obyekt yaranir
        Student student = StudentUtil.fillStudent();
        Config.students[index - 1] = student;
    }
}
