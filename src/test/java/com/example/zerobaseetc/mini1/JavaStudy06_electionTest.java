package com.example.zerobaseetc.mini1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JavaStudy06_electionTest {

    @Test
    void test() {
        Map<Integer, String> candidates = new HashMap<>();
        candidates.put(1, "이재명");
        candidates.put(2, "윤석열");
        candidates.put(3, "심상정");
        candidates.put(4, "안철수");
        Integer numberOfVote = 10000;

        Map<Integer, Integer> simulation = JavaStudy06_election.simulation(candidates, numberOfVote);
        System.out.println(simulation);
    }

}
