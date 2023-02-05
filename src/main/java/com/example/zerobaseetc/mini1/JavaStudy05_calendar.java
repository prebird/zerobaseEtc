package com.example.zerobaseetc.mini1;

import java.util.Calendar;
import java.util.Scanner;

/*
    정용규
 */


public class JavaStudy05_calendar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        Integer year = sc.nextInt();
        System.out.print("달력의 년도를 입력해 주세요.(mm):");
        Integer month = sc.nextInt();

        System.out.println();
        System.out.println();
        printCalandar(year, month);
    }

    public static void printCalandar(Integer year, Integer month) {
        String title = String.format("[%d년 %02d]", year, month);

        Calendar sDay = Calendar.getInstance();
        sDay.set(year, month-1, 1);
        Calendar eDay = Calendar.getInstance();
        eDay.set(year, month, 1);
        eDay.add(Calendar.DATE, -1);

        Integer startDayOfWeek = sDay.get(Calendar.DAY_OF_WEEK);
        Integer endDay = eDay.get(Calendar.DATE);


        System.out.println("일  월   화   수  목  금  토");

        String blank = "  ";
        // 첫 주 빈칸
        for (int i = 1; i < startDayOfWeek; i++) {
            System.out.print("  ");
            System.out.print(blank);
        }
        // 일 찍기
        int dayOfWeek = startDayOfWeek;
        for (int date = 1; date < endDay + 1; date++) {

            System.out.print(String.format("%02d", date));
            dayOfWeek += 1;
            if (dayOfWeek == 8) {
                System.out.println();
                dayOfWeek = 1;
            }
            else {
                System.out.print(blank);
            }
        }
        System.out.print(blank);
    }
}
