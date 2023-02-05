package com.example.zerobaseetc.mini1;

import java.util.*;

/*
    정용규
 */


public class JavaStudy02_cashback {
    private static Integer MAX_CASHBACK_AMOUNT = 300;
    private static float PAYBACK_RATE = 0.1f;
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        Integer payAmount = userInput();

        Integer cashbackAmount = calculateCashback(payAmount);

        String printFormat = String.format("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", payAmount, cashbackAmount);
        System.out.println(printFormat);
    }

    private static Integer userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static Integer calculateCashback(Integer payAmount) {
        Integer afterApplyRate = (int)(payAmount * PAYBACK_RATE);
        Integer trimmedAmount = (afterApplyRate / 100) * 100; // 백원 단위
        if (trimmedAmount >= MAX_CASHBACK_AMOUNT) {
            return MAX_CASHBACK_AMOUNT;
        }
        return trimmedAmount;
    }
}
