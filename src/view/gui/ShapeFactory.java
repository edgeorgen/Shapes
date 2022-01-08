package view.gui;

import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;

import java.awt.*;
import java.text.BreakIterator;
import model.persistence.ApplicationState;

public class ShapeFactory {


    public static BasicShape getShape(ShapeType shapeType, int x1, int y1, int x2, int y2, Color PrimaryColor, Color EdgeColor, ShapeShadingType shapeShadingType,
                                       int[] selected, PaintCanvas canvas){
        if( shapeType.equals(ShapeType.RECTANGLE)) {
            return rectangle(x1, y1, x2, y2, PrimaryColor, EdgeColor, shapeShadingType, selected, canvas);
        }
        if(shapeType.equals(ShapeType.ELLIPSE)) {
            return ellipse(x1, y1, x2, y2, PrimaryColor, EdgeColor, shapeShadingType, selected, canvas);
        }
        if(shapeType.equals(ShapeType.TRIANGLE)) {
            return triangle(x1, y1, x2, y2, PrimaryColor, EdgeColor, shapeShadingType, selected, canvas);
        }

        return null;
    }



    private static RectangularShape rectangle(int x1, int y1, int x2, int y2, Color PrimaryColor, Color EdgeColor, ShapeShadingType shapeShadingType,
                                               int[] selected, PaintCanvas canvas) {
        return new RectangularShape(x1, y1, x2, y2, PrimaryColor, EdgeColor, shapeShadingType, selected, canvas);
    }

    private static EllipseShape ellipse(int x1, int y1, int x2, int y2, Color PrimaryColor, Color EdgeColor, ShapeShadingType shapeShadingType,
                                         int[] selected, PaintCanvas canvas) {
        return new EllipseShape(x1, y1, x2, y2, PrimaryColor, EdgeColor, shapeShadingType,selected, canvas);
    }

    private static TriangleShape triangle(int x1, int y1, int x2, int y2, Color PrimaryColor, Color EdgeColor, ShapeShadingType shapeShadingType,
                                          int[] selected, PaintCanvas canvas) {
        return new TriangleShape(x1, y1, x2, y2, PrimaryColor, EdgeColor, shapeShadingType, selected, canvas);

    }

}
