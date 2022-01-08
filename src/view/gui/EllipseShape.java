package view.gui;

import model.ShapeShadingType;
import model.StartAndEndPointMode;

import java.awt.*;
import model.persistence.ApplicationState;

public class EllipseShape extends BasicShape {

    public EllipseShape(int xstart, int ystart, int xend, int yend, Color PrimaryColor, Color EdgeColor, ShapeShadingType shapeShadingType,
                        int[] selected, PaintCanvas canvas) {

        super(xstart, ystart, xend, yend, PrimaryColor, EdgeColor, shapeShadingType, selected, canvas);
    }

    @Override
    public void drawOutline(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getEdgeColor());
        g2.drawOval(getXstart(), getYstart(), getWidth(), getHeight());
        if (isSelected()) {
            g2.setColor(Color.BLACK);
            g2.drawRect(getXstart() - 2, getYstart() - 2, getWidth() + 4, getHeight() + 4);

        }
    }

    @Override
    public void drawFilled(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getPrimaryColor());
        g2.fillOval(getXstart(), getYstart(), getWidth(), getHeight());
        if (isSelected()) {
            g2.setColor(Color.BLACK);
            g2.drawRect(getXstart() - 2, getYstart() - 2, getWidth() + 4, getHeight() + 4);

        }

    }

    @Override
    public void drawBoth(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getPrimaryColor());
        g2.fillOval(getXstart(), getYstart(), getWidth(), getHeight());
        g2.setColor(getEdgeColor());
        g2.drawOval(getXstart(), getYstart(), getWidth(), getHeight());
        if (isSelected()) {
            g2.setColor(Color.BLACK);
            g2.drawRect(getXstart() - 2, getYstart() - 2, getWidth() + 4, getHeight() + 4);

        }

    }

    public static void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2 = (Graphics2D) g;
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        g2.setColor(Color.black);
        g2.drawOval(x1, y1, width, height);
    }

}
