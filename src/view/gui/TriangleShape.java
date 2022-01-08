package view.gui;

import model.ShapeShadingType;
import model.StartAndEndPointMode;

import java.awt.*;
import model.persistence.ApplicationState;

public class TriangleShape extends BasicShape {
    public TriangleShape(int xstart, int ystart, int xend, int yend, Color PrimaryColor, Color EdgeColor, ShapeShadingType shapeShadingType,
                            int[] selected, PaintCanvas canvas) {
        super(xstart, ystart, xend, yend, PrimaryColor, EdgeColor, shapeShadingType, selected, canvas);

    }

    @Override
    public void drawOutline(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getEdgeColor());
        int[] xx= {getXstart(),getXend(),getXend()};
        int[] yy = {getYstart(),getYstart(),getYend()};
        g2.drawPolygon(xx, yy, 3);
        if (isSelected()) {
            g2.setColor(Color.BLACK);
            g2.drawRect(getXstart()-5, getYstart() - 5, getWidth() + 10, getHeight() + 10);

        }
    }

    @Override
    public void drawFilled(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getPrimaryColor());
        int[] xx= {getXstart(),getXend(),getXend()};
        int[] yy = {getYstart(),getYstart(),getYend()};
        g2.fillPolygon(xx, yy, 3);
        if (isSelected()) {
            g2.setColor(Color.BLACK);
            g2.drawRect(getXstart() - 5, getYstart() - 5, getWidth() + 10, getHeight() + 10);

        }
    }

    @Override
    public void drawBoth(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getPrimaryColor());
        int[] xx= {getXstart(),getXend(),getXend()};
        int[] yy = {getYstart(),getYstart(),getYend()};
        g2.fillPolygon(xx, yy, 3);
        g2.setColor(getEdgeColor());
        g2.drawPolygon(xx, yy, 3);
        if (isSelected()) {
            g2.setColor(Color.BLACK);
            g2.drawRect(getXstart() - 5, getYstart() - 5, getWidth() + 10, getHeight() + 10);

        }

    }

    public static void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2 = (Graphics2D) g;
        int[] xx = {x1, x2, x2};
        int[] yy = {y1, y1, y2};
        g2.setColor(Color.black);
        g2.drawPolygon(xx, yy, 3);
    }

}
