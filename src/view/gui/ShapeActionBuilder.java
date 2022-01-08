package view.gui;

import model.ShapeShadingType;

import java.awt.*;

public class ShapeActionBuilder {
    private int startx;
    private int starty;
    private int endx;
    private int endy;
    private int id;
    private int action;
    private int shape;
    private Color primaryColor;
    private Color edgeColor;
    private ShapeShadingType shapeShadingType;

    public ShapeActionBuilder setStartx(int startx) {
        this.startx = startx;
        return this;
    }

    public ShapeActionBuilder setStarty(int starty) {
        this.starty = starty;
        return this;
    }

    public ShapeActionBuilder setEndx(int endx) {
        this.endx = endx;
        return this;
    }

    public ShapeActionBuilder setEndy(int endy) {
        this.endy = endy;
        return this;
    }

    public ShapeActionBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ShapeActionBuilder setAction(int action) {
        this.action = action;
        return this;
    }

    public ShapeActionBuilder setShape(int shape) {
        this.shape = shape;
        return this;
    }

    public ShapeActionBuilder setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
        return this;
    }

    public ShapeActionBuilder setEdgeColor(Color edgeColor) {
        this.edgeColor = edgeColor;
        return this;
    }

    public ShapeActionBuilder setShapeShadingType(ShapeShadingType shapeShadingType) {
        this.shapeShadingType = shapeShadingType;
        return this;
    }

    public ShapeAction createShapeAction() {
        return new ShapeAction(startx, starty, endx, endy, id, action, shape, primaryColor, edgeColor, shapeShadingType);
    }
}