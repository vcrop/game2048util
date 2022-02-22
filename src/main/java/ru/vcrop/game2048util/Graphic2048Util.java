package ru.vcrop.game2048util;

import java.io.IOException;
import java.io.OutputStream;

public interface Graphic2048Util<T> {
    void getOutputStream(T obj, OutputStream outputStream) throws IOException;
}
