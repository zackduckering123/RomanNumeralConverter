package com.company;

import java.util.Scanner;

public class Main {
    public static String UserNumeral = "";
    public static String[] UserSArray = new String[15];
    public static Integer[] UserIArray = new Integer[15];

    public static void main(String[] args) {
        AddToUserS();

        boolean valid = AddToUserI();
        if (valid) {
            System.out.println("Your numeral converted into a number is " + MakeNum());
        } else {
            System.out.println("This is not a roman numeral");
        }

    }

    public static void AddToUserS() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your number in roman numerals up to M");
        UserNumeral = input.nextLine();

        for (int i = 0; i < UserNumeral.length(); i++) {
            UserSArray = UserNumeral.split("");
        }
    }


    public static boolean AddToUserI() {
        boolean valid = true;
        for (int i = 0; i < UserNumeral.length(); i++) {
            if (UserSArray[i].equalsIgnoreCase("i")) {
                UserIArray[i] = 1;
            } else if (UserSArray[i].equalsIgnoreCase("v")) {
                UserIArray[i] = 5;
            } else if (UserSArray[i].equalsIgnoreCase("x")) {
                UserIArray[i] = 10;
            } else if (UserSArray[i].equalsIgnoreCase("l")) {
                UserIArray[i] = 50;
            } else if (UserSArray[i].equalsIgnoreCase("c")) {
                UserIArray[i] = 100;
            } else if (UserSArray[i].equalsIgnoreCase("d")) {
                UserIArray[i] = 500;
            } else if (UserSArray[i].equalsIgnoreCase("m")) {
                UserIArray[i] = 1000;
            } else {
                valid = false;
            }
        }
        return valid;
    }

    public static int MakeNum() {

        int Num = 0;
        UserIArray[UserNumeral.length()] = 0;
        for (int i = 0; i < UserNumeral.length(); i++) {
            if (UserIArray[i] < UserIArray[i + 1]) {
                int temp = UserIArray[i + 1] - UserIArray[i];
                Num = Num + temp;
                i = i + 1;
            } else {
                Num = Num + UserIArray[i];
            }
        }
        return Num;
    }
}

