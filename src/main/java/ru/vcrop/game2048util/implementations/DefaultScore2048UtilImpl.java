package ru.vcrop.game2048util.implementations;

import ru.vcrop.game2048util.Score2048Util;
import ru.vcrop.game2048util.util.Event;

public class DefaultScore2048UtilImpl implements Score2048Util<Integer> {
    private int score;

    @Override
    public void clear() {
        score = 0;
    }

    @Override
    public void onEvent(Event event, Integer obj) {
        if (event == Event.MERGE) score += obj;
    }

    @Override
    public int get() {
        return score;
    }
}
