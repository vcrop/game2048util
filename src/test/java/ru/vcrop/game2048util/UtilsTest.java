package ru.vcrop.game2048util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vcrop.game2048util.util.Direction;

import java.util.ArrayList;
import java.util.List;

class UtilsTest {

    List<List<Integer>> matrix;

    @BeforeEach
    void init() {
        matrix = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) matrix.get(i).add(0);
        }
        matrix.get(1).set(2, 1);
    }

    @Test
    void clearMatrix() {
    }

    @Test
    void transformMatrixRight() {
        Utils.transformMatrix(matrix, Direction.RIGHT);
        Assertions.assertEquals(matrix.get(1).get(3), 1);
        Assertions.assertNotEquals(matrix.get(1).get(2), 1);
    }

    @Test
    void transformMatrixDown() {
        Utils.transformMatrix(matrix, Direction.DOWN);
        Assertions.assertEquals(matrix.get(3).get(2), 1);
        Assertions.assertNotEquals(matrix.get(1).get(2), 1);
    }

    @Test
    void transformMatrixUnion() {
        matrix.get(0).set(2, 1);
        Utils.transformMatrix(matrix, Direction.DOWN);
        Assertions.assertEquals(matrix.get(3).get(2), 2);
        Assertions.assertNotEquals(matrix.get(1).get(2), 1);
    }
}