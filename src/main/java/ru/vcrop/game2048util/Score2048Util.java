package ru.vcrop.game2048util;

import ru.vcrop.game2048util.util.Event;

public interface Score2048Util<T> {
    void clear();
    void onEvent(Event event, T obj);
    int get();
}
