/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class InputUtil {

    public static int requiredNumber(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        int answer = scanner.nextInt();
        return answer;
    }

    public static String requiredText(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String answer = scanner.nextLine();
        return answer;
    }
}
