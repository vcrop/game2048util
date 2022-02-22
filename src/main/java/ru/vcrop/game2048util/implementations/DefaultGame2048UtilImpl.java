package ru.vcrop.game2048util.implementations;

import ru.vcrop.game2048util.Game2048Util;
import ru.vcrop.game2048util.Score2048Util;
import ru.vcrop.game2048util.util.Direction;
import ru.vcrop.game2048util.util.Event;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultGame2048UtilImpl implements Game2048Util {

    private final Score2048Util<Integer> score2048Util;

    public DefaultGame2048UtilImpl(Score2048Util<Integer> score2048Util) {
        this.score2048Util = score2048Util;
    }

    public void init(List<List<Integer>> matrix) {
        clearMatrix(matrix);
        randomTile(matrix);
        randomTile(matrix);
    }

    public void transformMatrix(List<List<Integer>> matrix, Direction direction) {
        IntStream.range(0, direction.ordinal() % 4).forEach(n -> rotateMatrix(matrix));
        leftShiftMatrix(matrix);
        IntStream.range(0, (4 - direction.ordinal()) % 4).forEach(n -> rotateMatrix(matrix));
    }

    public void randomTile(List<List<Integer>> matrix) {
        List<Integer> tiles = IntStream.range(0, 16).filter(n -> matrix.get(n / 4).get(n % 4).equals(0)).boxed().collect(Collectors.toList());
        Collections.shuffle(tiles);
        matrix.get(tiles.get(0) / 4).set(tiles.get(0) % 4, randomInt());
    }

    public boolean full(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(List::stream).filter(i -> i != 0).count() == 16;
    }

    private void clearMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix)
            for (int i = 0; i < row.size(); i++) row.set(i, 0);
    }

    private int randomInt() {
        return ThreadLocalRandom.current().nextInt(10) != 9 ? 2 : 4;
    }

    private void leftShiftMatrix(List<List<Integer>> matrix) {
        matrix.forEach(row -> {
                    List<Integer> elems = row.stream().filter(n -> n != 0).collect(Collectors.toList());
                    for (int i = 0; i < elems.size() - 1; i++)
                        if (elems.get(i).equals(elems.get(i + 1))) {
                            elems.set(i, elems.get(i) + elems.remove(i + 1));
                            score2048Util.onEvent(Event.MERGE, elems.get(i));
                        }
                    IntStream.range(0, 4).forEach(n -> row.set(n, n < elems.size() ? elems.get(n) : 0));
                }
        );
    }

    private void rotateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> transformMatrix = IntStream.range(0, 4)
                .mapToObj(col -> IntStream.range(0, 4).mapToObj(row -> matrix.get(3 - row).get(col)).collect(Collectors.toList()))
                .collect(Collectors.toList());
        IntStream.range(0, 4).forEach(row -> matrix.set(row, transformMatrix.get(row)));
    }

}
