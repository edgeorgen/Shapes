package model;

import view.gui.*;
import model.interfaces.Strategy;

public class CopyStrategy implements Strategy {
    @Override
    public void execute(PaintCanvas canvas) {
        for(BasicShape shape : canvas.gatShapes()){
            System.out.println(shape.getId() + " " + shape.isSelected());
            if(shape.isSelected()){
                CopyShape copy = canvas.getCopy();
                copy.setXstart(shape.getXstart());
                copy.setYstart(shape.getYstart());
                copy.setXend(shape.getXend());
                copy.setYend(shape.getYend());
                copy.setPrimaryColor(shape.getPrimaryColor());
                copy.setEdgeColor(shape.getEdgeColor());
                copy.setShapeShadingType(shape.getShapeShadingType());
                if(shape instanceof RectangularShape){
                    copy.setType(1);
                }
                if(shape instanceof EllipseShape){
                    copy.setType(2);
                }
                if(shape instanceof TriangleShape){
                    copy.setType(3);
                }
                return;
            }

        }

    }
}
