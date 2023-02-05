package com.example.zerobaseetc.mini1;

import java.util.*;

public class JavaStudy06_election {
    private static Integer TOTAL_VOTE = 10000;
    public static void main(String[] args) {

        Map<Integer, String> candidates = new HashMap<>();
        candidates.put(1, "이재명");
        candidates.put(2, "윤석열");
        candidates.put(3, "심상정");
        candidates.put(4, "안철수");

        Random random = new Random();
        Integer numberOfVotes = random.nextInt(TOTAL_VOTE);

        Map<Integer, Integer> votes = simulation(candidates, numberOfVotes);

        float totalRate = (numberOfVotes / (float)TOTAL_VOTE) * 100;
        String printFormatTotalRate = String.format("%.2f%s", totalRate, "%");
        Integer winNum = findWinner(votes);

        String strFormat1 = String.format("[투표진행율]: %s, %d명 투표 => %s", printFormatTotalRate ,numberOfVotes, candidates.get(winNum));
        System.out.println(strFormat1);
        for (Integer num : candidates.keySet()) {
            Integer vote = votes.get(num);
            String rate = String.format("%.2f%s", (vote/(float)TOTAL_VOTE) * 100, "%");
            String strFormat2 = String.format("[기호:%d] %s: %s, (투표수: %d)", num ,candidates.get(num), rate, vote);
            System.out.println(strFormat2);
        }
    }

    private static Integer findWinner(Map<Integer, Integer> votes) {
        Integer maxNum = 0;
        Integer maxVote = -1;
        for(Integer key : votes.keySet()) {
            if (votes.get(key) > maxVote) {
                maxNum = key;
                maxVote = votes.get(key);
            }
        }
        return maxNum;
    }

    //TODO: 동률 방지로직 넣기
    public static Map<Integer, Integer> simulation(Map<Integer, String> candidates,
                                                    Integer numberOfVotes) {
        while(true) {
            Map<Integer, Integer> votes = new HashMap<>();
            for (Integer num : candidates.keySet()) {
                votes.put(num, 0);
            }

            Random random = new Random();
            for (int i = 0; i < numberOfVotes; i++) {
                Integer vote = random.nextInt(4) + 1;
                votes.replace(vote, votes.get(vote) + 1);
            }

            // 중복 승자 나오면 다시
            if(!isMultiWinner(votes)) {
                return votes;
            }
        }
    }

    private static boolean isMultiWinner(Map<Integer, Integer> votes) {
        Integer maxVote = Collections.max(votes.values());
        long count = votes.entrySet().stream()
                .filter(n -> n.getValue().equals(maxVote))
                .count();
        if (count > 1) {
            return true;
        }
        return false;
    }

}
