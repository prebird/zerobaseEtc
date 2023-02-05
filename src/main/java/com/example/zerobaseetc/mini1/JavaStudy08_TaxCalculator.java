package com.example.zerobaseetc.mini1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    정용규
    코딩테스트 풀이에서 클래스를 나누는 것은 비효율 적인가요?
 */


public class JavaStudy08_TaxCalculator {

    public static void main(String[] args) {

        List<TaxCriteria> chart = new ArrayList<>();
        chart.add(new TaxCriteria(12000000L, 0.06f, 0));
        chart.add(new TaxCriteria(46000000L, 0.15f, 1080000));
        chart.add(new TaxCriteria(88000000L, 0.24f, 5220000));
        chart.add(new TaxCriteria(150000000L, 0.35f, 14900000));
        chart.add(new TaxCriteria(300000000L, 0.38f, 19400000));
        chart.add(new TaxCriteria(500000000L, 0.4f, 25400000));
        chart.add(new TaxCriteria(1000000000L, 0.42f, 35400000));
        chart.add(new TaxCriteria(Long.MAX_VALUE, 0.4f, 25400000));
        
        // 입력
        System.out.println("[과세금액 계산 프로그램]");
        System.out.println("연소득을 입력해 주세요.:");
        Scanner scanner = new Scanner(System.in);
        Long TOTAL_INCOME = scanner.nextLong();
        
        // 해당되는 세금 구간 찾기
        Integer findIdx = findTaxCriteriaIndex(TOTAL_INCOME, chart);

        // 세금 계산
        TaxCriteria taxCriteria = chart.get(findIdx);

        Long taxApplyDeduction = taxCriteria.calculateTaxApplyDeduction(TOTAL_INCOME);
        
        // 세율에 의한 세금 계산
        Long taxByRate = 0L;
        Long appliedAmount = 0L;
        for (int i = 0; i <= findIdx; i++) {
            TaxCriteria criteria = chart.get(i);

            Long applyAmount = 0L;
            if (!criteria.isApplicable(TOTAL_INCOME)) {
                applyAmount = criteria.limit - appliedAmount;
            }
            else {
                applyAmount = TOTAL_INCOME - appliedAmount;
            }

            //Long applyAmount = criteria.applyAmount(amount);
            String rate = criteria.rateToPrintFormat();
            Long tax = criteria.calculateTax(applyAmount);

            taxByRate += tax;
            String str = String.format("%10d * %s = %12d",applyAmount, rate, tax);
            System.out.println(str);
            appliedAmount += applyAmount;
        }

        System.out.println();
        String str2 = String.format("[세율에 의한 세금]:  %17d", taxByRate);
        String str3 = String.format("[누진공제 계산에 의한 세금]:  %10d", taxApplyDeduction);
        System.out.println(str2);
        System.out.println(str3);
    }

    private static Integer findTaxCriteriaIndex(Long totalIncome, List<TaxCriteria> chart) {
        for (int i = 0; i < chart.size(); i++) {
            TaxCriteria taxCriteria = chart.get(i);
            if (taxCriteria.isApplicable(totalIncome)) {
                return i;
            }
        }
        return chart.size() - 1;
    }

    private static class TaxCriteria {
        public Long limit;
        public Float rate;
        public Integer deduction;

        public TaxCriteria(Long limit, Float rate, Integer deduction) {
            this.limit = limit;
            this.rate = rate;
            this.deduction = deduction;
        }

        public Boolean isApplicable(Long amount) {
            return amount <= limit;
        }

        public Long applyAmount(Long amount) {
            if (amount <= limit) {
                return amount;
            }
            return limit;
        }

        public Long calculateTax(Long amount) {
            return (long)(amount * rate);
        }

        public Long calculateTaxApplyDeduction(Long amount) {
            return (long)(amount * rate) - deduction;
        }

        public String rateToPrintFormat() {
            return String.format("%2d%s", (int)(rate * 100), "%");
        }
    }

}

