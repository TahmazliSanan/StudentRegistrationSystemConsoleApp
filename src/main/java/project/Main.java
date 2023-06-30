/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import util.InputUtil;
import util.StudentUtil;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        int menu = 0;
        while (true) {
            menu = InputUtil.requiredNumber("""
                           What do you want to do?
                           1) Registration
                           2) Show students
                           3) Find student
                           4) Update student
                           """);

            switch (menu) {
                case 1 ->
                    StudentUtil.registerStudent();
                case 2 ->
                    StudentUtil.printRegisteredStudents();
                case 3 ->
                    StudentUtil.findStudentsAndPrint();
                case 4 ->
                    StudentUtil.updateStudentWithSameObject();
                default -> {
                }
            }
        }
    }
}
