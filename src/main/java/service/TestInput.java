package service;


import java.util.Scanner;

public class TestInput {
    public static final Scanner sc = new Scanner(System.in);
    public static String inputString(String name) {
        System.out.println("Enter " + name + " :");
        return sc.nextLine();
    }

    public static Integer inputInteger(String name) {
        Integer a;
        while (true) {
            try {
                System.out.println("Enter " + name + " :");
                a = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("wrong format re-enter");
            }
        }
        return a;
    }

    public static Float inputDouble(String name) {
        Float a;
        while (true) {
            try {
                System.out.println("Enter " + name + " :");
                a = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("wrong format re-enter");
            }
        }
        return a;
    }
}
