package com.example.zerobaseetc.mini1;

import java.util.*;

public class JavaStudy03_amusementPark {
    private static Integer FREE_FEE = 0;
    private static Integer GENERAL_FEE = 10000;
    private static Integer SPECIAL_DISCOUNT_FEE = 4000;
    private static Integer GENERAL_DISCOUNT_FEE = 8000;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        Integer age = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        Integer entryHour = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        Character nationManYn = sc.next().charAt(0);
        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        Character cardYn = sc.next().charAt(0);

        Integer entryFee = calculateEntryFee(age, entryHour, nationManYn, cardYn);

        String printFormat = "입장료: " + entryFee;
        System.out.println(printFormat);
    }

    public static Integer calculateEntryFee(Integer age, Integer entryHour,
                                             Character nationManYn, Character cardYn) {
        if (age < 3) return FREE_FEE;
        if (nationManYn == 'y' || cardYn == 'y') return GENERAL_DISCOUNT_FEE;
        if (age < 13) return SPECIAL_DISCOUNT_FEE;
        if (entryHour >= 17) return SPECIAL_DISCOUNT_FEE;
        return GENERAL_FEE;
    }
}
