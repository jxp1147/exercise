package com.shookmaker.exercise;

import com.shookmaker.exercise.uitls.GenerateModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseApplicationTests {
    @Autowired
    private GenerateModel generateModel;

    @Test
    void contextLoads() {
        try {
            generateModel.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
