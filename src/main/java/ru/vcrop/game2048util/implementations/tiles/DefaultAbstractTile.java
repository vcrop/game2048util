package ru.vcrop.game2048util.implementations.tiles;

public abstract class DefaultAbstractTile {
    private final int value;
    private final String color;
    private final int font_size;
    private final int font_x_pos;
    private final int font_y_pos;
    private final String font_color;

    public String getName() {
        return name;
    }

    private final String name;

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public int getFont_size() {
        return font_size;
    }

    public int getFont_x_pos() {
        return font_x_pos;
    }

    public int getFont_y_pos() {
        return font_y_pos;
    }

    public String getFont_color() {
        return font_color;
    }

    public DefaultAbstractTile(int value, String color, int font_size, int font_x_pos, int font_y_pos, String font_color, String name) {
        this.value = value;
        this.color = color;
        this.font_size = font_size;
        this.font_x_pos = font_x_pos;
        this.font_y_pos = font_y_pos;
        this.font_color = font_color;
        this.name = name;
    }
}
