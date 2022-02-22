package ru.vcrop.game2048util.util;

import ru.vcrop.game2048util.Score2048Util;

import java.util.List;

public class ComposeMatrixScoreClass {

    private final List<List<Integer>> matrix;

    private final Score2048Util<Integer> score2048Util;

    public List<List<Integer>> getMatrix() {
        return matrix;
    }

    public Score2048Util<Integer> getScore2048Util() {
        return score2048Util;
    }

    public ComposeMatrixScoreClass(List<List<Integer>> matrix, Score2048Util<Integer> score2048Util) {
        this.matrix = matrix;
        this.score2048Util = score2048Util;
    }
}
