package view.gui;

import model.ShapeShadingType;
import model.StartAndEndPointMode;

import java.awt.*;

public class CopyShape {


    private int xstart;
    private int ystart;
    private int xend;
    private int yend;
    private int n;
    private Color PrimaryColor;
    private Color EdgeColor;
    private ShapeShadingType shapeShadingType;
    private static CopyShape instance = null;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;

    private CopyShape(){

    }

    public static CopyShape getInstance(){
        if(instance == null){
            instance = new CopyShape();

        }
        return instance;
    }


    public Color getPrimaryColor() {
        return PrimaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        PrimaryColor = primaryColor;
    }

    public Color getEdgeColor() {
        return EdgeColor;
    }

    public void setEdgeColor(Color edgeColor) {
        EdgeColor = edgeColor;
    }

    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }

    public void setShapeShadingType(ShapeShadingType shapeShadingType) {
        this.shapeShadingType = shapeShadingType;
    }

    public int getXstart() {
        return xstart;
    }

    public void setXstart(int xstart) {
        this.xstart = xstart;
    }

    public int getYstart() {
        return ystart;
    }

    public void setYstart(int ystart) {
        this.ystart = ystart;
    }

    public int getXend() {
        return xend;
    }

    public void setXend(int xend) {
        this.xend = xend;
    }

    public int getYend() {
        return yend;
    }

    public void setYend(int yend) {
        this.yend = yend;
    }
}
