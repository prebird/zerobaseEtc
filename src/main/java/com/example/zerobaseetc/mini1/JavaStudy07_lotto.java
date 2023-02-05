package com.example.zerobaseetc.mini1;

import java.util.*;

public class JavaStudy07_lotto {
    public static void main(String[] args) {

        System.out.println("[로또 당첨 프로그램]");
        System.out.print("로또의 갯수를 입력해 주세요.(숫자 1 ~ 10):");
        //입력
        Scanner scanner = new Scanner(System.in);
        Integer cnt = scanner.nextInt();

        // 로또 생성
        ArrayList<int[]> lottos = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            lottos.add(generatelotto());
        }

        // 정답 생성
        int[] answer = generatelotto();

        // 판정
        ArrayList<Integer> matchCounts = new ArrayList<>();
        for (int[] lotto : lottos) {
            matchCounts.add(matches(answer, lotto));
        }

        // 출력
        for (int i = 0; i < cnt; i++) {
            System.out.println(makePrintLottoFormat(i, lottos.get(i)));
        }
        System.out.println();
        System.out.println("[로또 발표]");
        System.out.println("    " + lottoToString(answer));
        System.out.println();
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < cnt; i++) {
            System.out.println(makePrintMatchesFormat(i, lottos.get(i), matchCounts.get(i)));
        }
    }

    public static String lottoToString(int[] lotto) {
        String str = "";
        for (int num : lotto) {
            str += String.format("%02d", num);
            str += ",";
        }
        return str.substring(0, str.length() - 1);
    }

    public static String makePrintLottoFormat(int th, int[] lotto) {
        String str = String.valueOf((char)(th + 65));
        str += "   ";
        str += lottoToString(lotto);
        return str;
    }

    public static String makePrintMatchesFormat(int th, int[] lotto, Integer matchCount) {
        return String.format(makePrintLottoFormat(th, lotto) + " => %d개 일치", matchCount);
    }

    public static Integer matches(int[] answer, int[] myLotto) {
        int cnt = 0;
        for (int myNum : myLotto) {
            for (int answerNum : answer) {
                if (myNum == answerNum) {
                    cnt += 1;
                    break;
                }
            }
        }
        return cnt;
    }

    public static int[] generatelotto() {
        Random random = new Random();

        Set<Integer> lottoSet = new HashSet<>();
        while(lottoSet.size() < 6) {
            lottoSet.add(random.nextInt(45) + 1);
        }
        return lottoSet.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
}
