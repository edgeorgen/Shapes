package view.gui;

import model.ShapeShadingType;

import java.awt.*;

public class ShapeAction extends ShapeActionBuilder {
    private int startx;
    private int starty;
    private int endx;
    private int endy;
private int id;

    private int action;
    private int shape;
    private Color PrimaryColor;
    private Color EdgeColor;
    private ShapeShadingType shapeShadingType;

    public static int ADDACTION = 1;
    public static int REMOVEACTION = 2;
    public static int MOVEACTION = 3;

    public static int rectangle =1;
    public static int ellipse =2;
    public static int triangle =3;

    public ShapeAction(int startx, int starty, int endx, int endy, int id, int action, int shape, Color primaryColor, Color edgeColor, ShapeShadingType shapeShadingType) {
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.id = id;
        this.action = action;
        this.shape = shape;
        this.PrimaryColor = primaryColor;
        this.EdgeColor = edgeColor;
        this.shapeShadingType = shapeShadingType;
    }


    public int getStartx() {
        return startx;
    }


    public int getStarty() {
        return starty;
    }



    public int getEndx() {
        return endx;
    }



    public int getEndy() {
        return endy;
    }



    public int getShape() {
        return shape;
    }



    public Color getPrimaryColor() {
        return PrimaryColor;
    }



    public Color getEdgeColor() {
        return EdgeColor;
    }



    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }



    public int getAction() {
        return action;
    }

    public int getId(){
        return id;
    }


}
