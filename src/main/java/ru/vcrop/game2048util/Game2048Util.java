package ru.vcrop.game2048util;

import ru.vcrop.game2048util.util.Direction;

import java.util.List;

public interface Game2048Util {
    void init(List<List<Integer>> matrix);
    void transformMatrix(List<List<Integer>> matrix, Direction direction);
    void randomTile(List<List<Integer>> matrix);
    boolean full(List<List<Integer>> matrix);
}
