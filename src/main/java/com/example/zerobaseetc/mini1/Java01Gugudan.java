package com.example.zerobaseetc.mini1;

import java.util.*;

/*
    정용규
 */

public class Java01Gugudan {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                String formula = convertToPrintFormat(j, i);
                String blank = "\t";
                if (j != 9) {
                    formula += blank;
                }
                System.out.print(formula);
            }
            System.out.println("");
        }
    }

    private static String convertToPrintFormat(int num1, int num2) {
        return String.format("%02d X %02d = %02d", num1, num2, num1 * num2);
    }
}
