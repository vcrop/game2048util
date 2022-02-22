package ru.vcrop.game2048util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vcrop.game2048util.implementations.DefaultGame2048UtilImpl;
import ru.vcrop.game2048util.implementations.DefaultScore2048UtilImpl;
import ru.vcrop.game2048util.util.Direction;

import java.util.ArrayList;
import java.util.List;

class DefaultGame2048UtilImplTest {

    List<List<Integer>> matrix;
    Game2048Util game2048Util = new DefaultGame2048UtilImpl(new DefaultScore2048UtilImpl());

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
        game2048Util.transformMatrix(matrix, Direction.RIGHT);
        Assertions.assertEquals(matrix.get(1).get(3), 1);
        Assertions.assertNotEquals(matrix.get(1).get(2), 1);
    }

    @Test
    void transformMatrixDown() {
        game2048Util.transformMatrix(matrix, Direction.DOWN);
        Assertions.assertEquals(matrix.get(3).get(2), 1);
        Assertions.assertNotEquals(matrix.get(1).get(2), 1);
    }

    @Test
    void transformMatrixUnion() {
        matrix.get(0).set(2, 1);
        game2048Util.transformMatrix(matrix, Direction.DOWN);
        Assertions.assertEquals(matrix.get(3).get(2), 2);
        Assertions.assertNotEquals(matrix.get(1).get(2), 1);
    }

    @Test
    void initTest() {
        int count2 = 0;
        int count4 = 0;
        int count_another = 0;
        game2048Util.init(matrix);
        for (List<Integer> row : matrix)
            for (int i : row) {
                if (i == 2) count2++;
                else if (i == 4) count4++;
                else if (i != 0) count_another++;
            }
        Assertions.assertTrue(count2 < 3);
        Assertions.assertTrue(count4 < 2);
        Assertions.assertEquals(count2 + count4, 2);
        Assertions.assertEquals(0, count_another);
    }

    @Test
    void fullTilesTest() {
        int count2 = 0;
        int count4 = 0;
        int count_another = 0;
        game2048Util.init(matrix);
        for (int i = 0; i < 14; i++) game2048Util.randomTile(matrix);
        for (List<Integer> row : matrix)
            for (int i : row) {
                if (i == 2) count2++;
                else if (i == 4) count4++;
                else if (i != 0) count_another++;
            }
        Assertions.assertTrue(count2 < 17);
        Assertions.assertTrue(count4 < 17);
        Assertions.assertEquals(count2 + count4, 16);
        Assertions.assertEquals(0, count_another);
        Assertions.assertTrue(game2048Util.full(matrix));
    }
}