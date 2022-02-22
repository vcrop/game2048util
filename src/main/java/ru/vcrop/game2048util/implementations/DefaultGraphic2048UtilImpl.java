package ru.vcrop.game2048util.implementations;

import ru.vcrop.game2048util.Graphic2048Util;
import ru.vcrop.game2048util.implementations.tiles.*;
import ru.vcrop.game2048util.util.ComposeMatrixScoreClass;
import ru.vcrop.game2048util.util.TileSet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class DefaultGraphic2048UtilImpl implements Graphic2048Util<ComposeMatrixScoreClass> {

    @Override
    public void getOutputStream(ComposeMatrixScoreClass obj, OutputStream outputStream) throws IOException {
        BufferedImage canvas = new BufferedImage(2400, 2400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = canvas.createGraphics();
        drawCanvas(graphics2D);
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                DefaultAbstractTile tile = TileSet.get(obj.getMatrix().get(row).get(col));
                drawTile(graphics2D, row, col, tile);
                drawNumber(graphics2D, row, col, tile);
            }
        ImageIO.write(canvas, "PNG", outputStream);
    }

    private void drawCanvas(Graphics2D graphics2D) {
        graphics2D.setColor(Color.decode("0xbbada0"));
        graphics2D.fillRoundRect(0, 0, 2400, 2400, 50, 50);
    }

    private void drawTile(Graphics2D graphics2D, int row, int col, DefaultAbstractTile tile) {
        graphics2D.setColor(Color.decode(tile.getColor()));
        graphics2D.fillRoundRect(80 + row * 580, 80 + col * 580, 500, 500, 50, 50);
    }

    private void drawNumber(Graphics2D graphics2D, int row, int col, DefaultAbstractTile tile) {
        graphics2D.setColor(Color.decode(tile.getFont_color()));
        graphics2D.setFont(new Font("Courier New", Font.BOLD, tile.getFont_size()));
        graphics2D.drawString(tile.getName(), 80 + tile.getFont_x_pos() + row * 580, 80 + tile.getFont_y_pos() + col * 580);
    }
}
