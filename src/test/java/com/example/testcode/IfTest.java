package com.example.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class IfTest {

    static String VALUE = "TEST";

    @Test
    @DisplayName("조건 테스트")
    void assumeTest(){
        assumeTrue("실행 안됨".equals(VALUE));
        System.out.println("조건 테스트");
    }

    @Test
    @DisplayName("무조건 실행")
    void test(){
        System.out.println("무조건 실행되는 테스트");
    }

    @Test
    @DisplayName("조건 테스트2")
    void assumeThat(){
        assumingThat("실행 안됨".equals(VALUE), ()-> System.out.println("실행"));
        assumingThat("TEST".equals(VALUE), ()-> System.out.println("실행"));
    }

    @Test
    @DisplayName("window만 실행")
    @EnabledOnOs(value = OS.WINDOWS)
    void window(){
        System.out.println("윈도우 테스트입니다.");
    }

    @Test
    @DisplayName("window 외 실행")
    @DisabledOnOs(value = OS.WINDOWS)
    void disabledWindow(){
        System.out.println("윈도우에서는 실행하지 않을 테스트입니다..");
    }


    @Test
    @DisplayName("linux, max만 실행")
    @EnabledOnOs(value = {OS.MAC, OS.LINUX})
    void mac(){
        System.out.println("mac, linux 테스트입니다.");
    }

    @Test
    @DisplayName("java11에서만 실행")
    @EnabledOnJre(value = {JRE.JAVA_11})
    void java11(){
        System.out.println("java 11에서만 실행");
    }

    @Test
    @DisplayName("java11 외 실행")
    @DisabledOnJre(value = {JRE.JAVA_11})
    void disabledJava11(){
        System.out.println("java 11 외 실행");
    }

    @Test
    @DisplayName("java11 외 실행")
    @EnabledOnJre(value = {JRE.JAVA_8, JRE.JAVA_18})
    void disabledJava8(){
        System.out.println("java 8, 11에서만 실행");
    }
}
