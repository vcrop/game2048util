package ru.vcrop.game2048util.util;

import ru.vcrop.game2048util.Tile2048Util;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class DefaultGraphicTileSet {
    static Map<Integer,Tile2048Util> integerDefaultAbstractTileMap = new HashMap<>();
    static {
        integerDefaultAbstractTileMap.put(0, new DefaultTile(0, "0xccc0b4", 300, 150, 370, "0x958d83", ""));
        integerDefaultAbstractTileMap.put(2, new DefaultTile(2, "0xeee4da", 300, 150, 370, "0x776e65", "2"));
        integerDefaultAbstractTileMap.put(4, new DefaultTile(4, "0xede0c8", 300, 150, 370, "0x776e65", "4"));
        integerDefaultAbstractTileMap.put(8, new DefaultTile(8, "0xf2b179", 300, 150, 370, "0xf9f6f2", "8"));
        integerDefaultAbstractTileMap.put(16, new DefaultTile(16, "0xec8d53", 300, 40, 370, "0xf9f6f2", "16"));
        integerDefaultAbstractTileMap.put(32, new DefaultTile(32, "0xec8d53", 300, 40, 370, "0xf9f6f2", "32"));
        integerDefaultAbstractTileMap.put(64, new DefaultTile(64, "0xe95839", 300, 40, 370, "0xf9f6f2", "64"));
        integerDefaultAbstractTileMap.put(128, new DefaultTile(128, "0xedd072", 200, 40, 340, "0xf9f6f2", "128"));
        integerDefaultAbstractTileMap.put(256, new DefaultTile(256, "0xeacc5e", 200, 40, 340, "0xf9f6f2", "256"));
        integerDefaultAbstractTileMap.put(512, new DefaultTile(512, "0xebc84e", 200, 40, 340, "0xf9f6f2", "512"));
        integerDefaultAbstractTileMap.put(1024, new DefaultTile(1024, "0xecc43e", 150, 40, 310, "0xf9f6f2", "1024"));
        integerDefaultAbstractTileMap.put(2048, new DefaultTile(2048, "0xe9bf2c", 150, 40, 310, "0xf9f6f2", "2048"));
        integerDefaultAbstractTileMap.put(4096, new DefaultTile(4096, "0xff3d40", 150, 40, 310, "0xf9f6f2", "4096"));
    }

    public static Tile2048Util get(int value) {
        if (integerDefaultAbstractTileMap.get(value) != null) return integerDefaultAbstractTileMap.get(value);
        throw new NoSuchElementException();
    }


    private static class DefaultTile implements Tile2048Util {
        int value;
        String color;
        int font_size;
        int font_x_pos;
        int font_y_pos;
        String font_color;
        String name;

        public DefaultTile(int value, String color, int font_size, int font_x_pos, int font_y_pos, String font_color, String name) {
            this.value = value;
            this.color = color;
            this.font_size = font_size;
            this.font_x_pos = font_x_pos;
            this.font_y_pos = font_y_pos;
            this.font_color = font_color;
            this.name = name;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public String getColor() {
            return color;
        }

        @Override
        public int getFont_size() {
            return font_size;
        }

        @Override
        public int getFont_x_pos() {
            return font_x_pos;
        }

        @Override
        public int getFont_y_pos() {
            return font_y_pos;
        }

        @Override
        public String getFont_color() {
            return font_color;
        }

        @Override
        public String getName() {
            return name;
        }



    }

}
