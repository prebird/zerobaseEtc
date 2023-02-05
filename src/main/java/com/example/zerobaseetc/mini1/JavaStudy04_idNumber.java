package com.example.zerobaseetc.mini1;

import java.util.*;

/*
    정용규
 */


public class JavaStudy04_idNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        Integer year = sc.nextInt();
        System.out.print("출생월을 입력해 주세요.(mm):");
        String month = sc.next();
        System.out.print("출생일을 입력해 주세요.(dd):");
        String day = sc.next();
        System.out.print("성별을 입력해 주세요.(m/f):");
        Character gender = sc.next().charAt(0);

        String idNumber = generateIdNumber(year, month, day, gender);

        System.out.println(idNumber);
    }

    public static String generateIdNumber(Integer year, String month,
                                          String day, Character gender) {
        String yy = String.valueOf(year).substring(2);
        String mm = String.format("%02d", Integer.valueOf(month));
        String dd = String.format("%02d", Integer.valueOf(day));
        String g = convertGenderToNumber(gender);

        String randomNumbers = "";
        Random random = new Random();
        for(int i = 0; i < 7; i++) {
            randomNumbers += random.nextInt(10);
        }
        String idNumber = yy + mm + dd + "-" + g + randomNumbers;
        return idNumber;
    }
    private static String convertGenderToNumber(Character gender) {
        if(gender == 'm') return "1";
        if(gender == 'f') return "2";
        throw new IllegalArgumentException("성별은 m, f 둘 중 하나로 입력해 주세요");
    }
}
