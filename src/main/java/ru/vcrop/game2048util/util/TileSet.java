package ru.vcrop.game2048util.util;

import ru.vcrop.game2048util.implementations.tiles.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TileSet {
    static Map<Integer,DefaultAbstractTile> integerDefaultAbstractTileMap = new HashMap<>();
    static {
        integerDefaultAbstractTileMap.put(0, new DefaultTile0());
        integerDefaultAbstractTileMap.put(2, new DefaultTile2());
        integerDefaultAbstractTileMap.put(4, new DefaultTile4());
        integerDefaultAbstractTileMap.put(8, new DefaultTile8());
        integerDefaultAbstractTileMap.put(16, new DefaultTile16());
        integerDefaultAbstractTileMap.put(32, new DefaultTile32());
        integerDefaultAbstractTileMap.put(64, new DefaultTile64());
        integerDefaultAbstractTileMap.put(128, new DefaultTile128());
        integerDefaultAbstractTileMap.put(256, new DefaultTile256());
        integerDefaultAbstractTileMap.put(512, new DefaultTile512());
        integerDefaultAbstractTileMap.put(1024, new DefaultTile1024());
        integerDefaultAbstractTileMap.put(2048, new DefaultTile2048());
        integerDefaultAbstractTileMap.put(4096, new DefaultTile4096());
    }

    public static DefaultAbstractTile get(int value) {
        if (integerDefaultAbstractTileMap.get(value) != null) return integerDefaultAbstractTileMap.get(value);
        throw new NoSuchElementException();
    }
}
