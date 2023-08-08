package Util;

import java.util.Scanner;

public class InputUtil {
    public static String inputRequiredString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLine();
    }

    public static byte inputRequiredByte(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextByte();
    }

    public static long inputRequiredLong(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLong();
    }
    public static int inputRequiredInt(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextInt();
    }
    public static boolean inputRequiredBoolean(Boolean b) {
        Scanner scanner = new Scanner(System.in);
        System.out.print( b);
        return scanner.nextBoolean();
    }
}
