package com.example.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TestCode {
    
    @Test
    @DisplayName("테스트")
    void test(){
        Car car = new Car(100);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> car.exception());
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("타임 아웃")
    void timeoutTest(){
        Car car = new Car(100);
        assertTimeout(Duration.ofMillis(1000), ()->{
                Thread.sleep(3000);
        });
    }

    static class Car{
        int speed;

        public Car(int speed) {
            this.speed = speed;
        }

        public void exception(){
            if(true) throw new IllegalArgumentException("내가 발생시킨 exception");
        }
    }
}
