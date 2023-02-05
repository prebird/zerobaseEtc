package com.example.zerobaseetc.mini1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaStudy04_idNumberTest {

    @Test
    void 주빈번호생성_960129_1xxxxxx() {
        Integer year = 1996;
        String month = "01";
        String day = "29";
        Character gender = 'm';
        String id = JavaStudy04_idNumber.generateIdNumber(year, month, day, gender);
        System.out.println("id = " + id);
    }

    @Test
    void 주빈번호생성_960129_1xxxxxx_2() {
        Integer year = 1996;
        String month = "01";
        String day = "29";
        Character gender = 'm';
        String id = JavaStudy04_idNumber.generateIdNumber(year, month, day, gender);
        System.out.println("id = " + id);
    }

}
